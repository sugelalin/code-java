package org.example.practicecode.designpattern.actionType.interpreter;

/**
 * 表达式接口
 */
public interface Expression {
    boolean interpret(String context);
}
