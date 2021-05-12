package org.example.practicecode.designpattern.strategy2;

/**
 * 环境角色
 */
public class Environment {
    private Strategy strategy;

    public Environment() {
    }

    public Environment(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int a, int b) {
        return strategy.calc(a, b);
    }
}
