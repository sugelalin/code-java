package org.example.practicejava.javaBase.condition;

/**
 * 嘉宾勋章策略实现类
 */
public class GuestMedalServiceImpl implements IMedalService {
    @Override
    public void showMedal() {
        System.out.println("嘉宾勋章");
    }
}
