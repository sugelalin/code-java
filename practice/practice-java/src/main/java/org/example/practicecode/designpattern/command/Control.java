package org.example.practicecode.designpattern.command;

/**
 * 请求者
 */
public class Control {

    public void commandTurnOn(Command command) {
        command.turnOn();
    }

    public void commandTurnOff(Command command) {
        command.turnOff();
    }
}
