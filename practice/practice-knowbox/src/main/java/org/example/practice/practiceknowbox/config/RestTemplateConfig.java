package org.example.practice.practiceknowbox.config;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.example.practice.practiceknowbox.common.web.interceptor.RestTemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RestTemplateConfig {

    @Autowired(required = false)
    private Registry<ConnectionSocketFactory> connectionSocketFactory;
    @Autowired(required = false)
    private ConnectionKeepAliveStrategy connectionKeepAliveStrategy;
    @Autowired(required = false)
    private HttpClientConnectionManager httpClientConnectionManager;

    @Value("${restTemplate.client.connectionRequestTimeout:2000}")
    private int connectionRequestTimeout;
    @Value("${restTemplate.client.connectTimeout:1000}")
    private int connectTimeout;
    @Value("${restTemplate.client.socketTimeout:3000}")
    private int socketTimeout;
    @Value("${restTemplate.client.pool.maxTotal:1000}")
    private int maxTotal;
    @Value("${restTemplate.client.pool.defaultMaxPerRoute:400}")
    private int defaultMaxPerRoute;

    @Value("${restTemplate.client.pool.idleConnectionWaitSeconds:30}")
    private int idleConnectionWaitSeconds;

    @Value("${restTemplate.slowclient.connectTimeout:2000}")
    private int slowConnectTimeout;
    @Value("${restTemplate.slowclient.socketTimeout:10000}")
    private int slowSocketTimeout;

    @Bean
    @Primary
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        restTemplate.setInterceptors(Collections.singletonList(new RestTemplateInterceptor()));
        return restTemplate;
    }

    /**
     * ?????????????????????
     *
     * @return
     */
    @Bean("slowRestTemplate")
    public RestTemplate slowRestTemplate() {
        Registry<ConnectionSocketFactory> registry = getDefaultConnectionSocketFactory();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(maxTotal);
        connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        connectionManager.setValidateAfterInactivity(2000);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(slowSocketTimeout)
                .setConnectTimeout(slowConnectTimeout).setConnectionRequestTimeout(connectionRequestTimeout).build();
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(HttpClientBuilder
                .create().setDefaultRequestConfig(requestConfig).setConnectionManager(connectionManager).build()));
        restTemplate.setInterceptors(Collections.singletonList(new RestTemplateInterceptor()));
        return restTemplate;
    }

    /**
     * ??????SSL??????
     */
    public static Registry<ConnectionSocketFactory> getDefaultConnectionSocketFactory() {
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
        return socketFactoryRegistry;
    }

    /**
     * ?????????????????????
     */
    private HttpClientConnectionManager poolingConnectionManager() {
        // ??????????????????connectionSocketFactory????????????bean???????????????SSL????????????
        if (connectionSocketFactory == null) {
            log.info("RestTemplateConfig Default ConnectionSocketFactory SSL????????????");
            connectionSocketFactory = getDefaultConnectionSocketFactory();
        } else {
            log.info("RestTemplateConfig ??????SSL????????????");
        }
        PoolingHttpClientConnectionManager poolingConnectionManager =
                new PoolingHttpClientConnectionManager(connectionSocketFactory);
        // ????????????????????????
        poolingConnectionManager.setMaxTotal(maxTotal);
        // ?????????????????????
        poolingConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        // ??????????????????
        poolingConnectionManager.closeExpiredConnections();
        // ??????n??????????????????????????????
        poolingConnectionManager.closeIdleConnections(idleConnectionWaitSeconds, TimeUnit.SECONDS);
        return poolingConnectionManager;
    }

    /**
     * ??????HTTPClientBuilder
     */
    private HttpClientBuilder httpClientBuilder() {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // ??????HTTP???????????????
        if (httpClientConnectionManager == null) {
            log.info("RestTemplateConfig Default HttpClientConnectionManager");
            httpClientConnectionManager = poolingConnectionManager();
        } else {
            log.info("RestTemplateConfig ?????????HTTP???????????????");
        }
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);
        // ????????????????????????
        if (connectionKeepAliveStrategy == null) {
            log.info("RestTemplateConfig Default ConnectionKeepAliveStrategy");
            connectionKeepAliveStrategy = DefaultConnectionKeepAliveStrategy.INSTANCE;
        } else {
            log.info("RestTemplateConfig ???????????????????????????");
        }
        httpClientBuilder.setKeepAliveStrategy(connectionKeepAliveStrategy);
        return httpClientBuilder;
    }

    /**
     * ??????ClientHttpRequestFactory
     */
    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClientBuilder().build());
        // ???????????????????????????????????????????????????
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        // ?????????????????????????????????
        clientHttpRequestFactory.setReadTimeout(socketTimeout);
        // ?????????????????????????????????
        clientHttpRequestFactory.setConnectionRequestTimeout(connectionRequestTimeout);
        return clientHttpRequestFactory;
    }
}
