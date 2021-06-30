package org.example.practicecode.designpattern.structureType.adapter;

/**
 * 适配器模式：将一个接口转换成客户希望的另一个接口，使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。 适配器模式既可以作为类结构型模式，也可以作为对象结构型模式
 *
 * 角色： Target（目标抽象类）：目标抽象类定义客户所需接口，可以是一个抽象类或接口，也可以是具体类。
 * Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配，适配器类是适配器模式的核心，在对象适配器中，它通过继承Target并关联一个Adaptee对象使二者产生联系。
 * Adaptee（适配者类）：适配者即被适配的角色，它定义了一个已经存在的接口/方法，这个接口/方法需要适配，适配者类一般是一个具体类，包含了客户希望使用的业务方法，在某些情况下可能没有适配者类的源代码。
 *
 * 优点：将目标类和适配者类解耦，增加了类的透明性和复用性，灵活性和扩展性都非常好，完全符合“开闭原则”。 缺点： 1、类适配器一次最多只能适配一个适配者类，使用有一定的局限性。（不能多继承）
 * 2、而对象适配器虽然可以把适配者类和它的子类都适配到目标接口，但是更改适配者的方法十分麻烦，既需要更改适配器，也需要更改适配者
 *
 * 应用：JDBC驱动软件就是一个介于JDBC接口和数据库引擎接口之间的适配器软件。
 *
 * 扩展：当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认实现（空方法），
 * 那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求，它适用于一个接口不想使用其所有的方法的情况。因此也称为单接口适配器模式。
 */
/**
 * 类适配器
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        System.out.println("pass by Adapter");
        super.adapteeRequest();
    }
}