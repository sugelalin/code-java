package org.example.springstart.aop.aoptx_anno;

import org.example.springstart.aop.aoptx_anno.domain.Account;
import org.example.springstart.aop.aoptx_anno.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 简单的基于Junit 的 Account测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/example/springstart/aop/aoptx_anno/bean.xml")
public class AccountTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testAccount() {
        List<Account> allAccount = as.findAllAccount();
        allAccount.forEach(account -> {
            System.out.println(account);
        });
    }

    @Test
    public void testTransfer() {
        as.transfer("aaa", "bbb", 100F);
    }
}
