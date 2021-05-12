package org.example.practicecode.designpattern.decorator;

import com.example.designpattern.decorator.Decorator;

/**
 * 装饰者实例，加巧克力
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        super.setDescription("Chocolate");
        super.setPrice(5.0F);
    }
}
