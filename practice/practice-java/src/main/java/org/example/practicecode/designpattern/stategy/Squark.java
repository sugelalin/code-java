package org.example.practicecode.designpattern.stategy;

import com.example.designpattern.stategy.QuackBehavior;

/**
 * @author wangyulin
 * @date 2020/6/1
 */
public class Squark implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squark!");
    }
}
