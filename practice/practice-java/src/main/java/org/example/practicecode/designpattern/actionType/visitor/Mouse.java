package org.example.practicecode.designpattern.actionType.visitor;

/**
 * 元素实体类
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
