package org.example.practicecode.designpattern.builder;

import com.example.designpattern.builder.ColdDrink;

/**
 * 百事可乐，继承冷饮抽象类
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
