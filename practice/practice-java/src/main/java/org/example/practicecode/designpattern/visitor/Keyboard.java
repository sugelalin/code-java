package org.example.practicecode.designpattern.visitor;

/**
 * 元素实体类
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
