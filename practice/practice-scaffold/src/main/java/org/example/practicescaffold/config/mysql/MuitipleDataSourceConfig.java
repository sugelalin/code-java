package org.example.practicescaffold.config.mysql;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 读取数据库配置 单库、一主多从、多主多从、纯分片
 */
@Component
@Data
@ConfigurationProperties("databaseconfig")
public class MuitipleDataSourceConfig {
    // 单库
    private String jayDefaultName;
    private MasterSlavesConfig jaydefault;
    // 一主多从
    private String jayOneName;
    private MasterSlavesConfig jayone;
    // 多主多从
    private String jayTwoName;
    private List<MasterSlavesConfig> jaytwo;
    // 纯分片
    private String jayThreeName;
    private List<MasterSlavesConfig> jaythree;

    private Map<String, Integer> shardingTables;
}
