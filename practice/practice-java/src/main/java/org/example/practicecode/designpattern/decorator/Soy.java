package org.example.practicecode.designpattern.decorator;

import com.example.designpattern.decorator.Decorator;
import com.example.designpattern.decorator.Drink;

/**
 * 装饰者实例，加咖啡豆
 */
public class Soy extends Decorator {

    public Soy(Drink drink) {
        super(drink);
        super.setDescription("Soy");
        super.setPrice(0.5F);
    }
}
