package org.example.practicecode.designpattern.builder;

/**
 * 蔬菜汉堡，继承汉堡抽象类
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
