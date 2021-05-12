package org.example.practicecode.designpattern.state2;

import com.example.designpattern.state2.StateEnum;

/**
 * 玩家，拥有状态的对象
 */
public class Player {

    private int state;

    public Player() {
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        System.out.println("切换玩家状态为：" + StateEnum.of(state));
    }
}
