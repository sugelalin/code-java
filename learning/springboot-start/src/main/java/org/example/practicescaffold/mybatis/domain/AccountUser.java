package org.example.practicescaffold.mybatis.domain;

/**
 * 关联到的信息不只有Account，还有User中的部分信息
 */
public class AccountUser extends Account {

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "account='" + super.toString() + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
