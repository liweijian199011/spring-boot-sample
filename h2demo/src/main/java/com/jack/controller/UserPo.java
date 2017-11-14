package com.jack.controller;

/**
 * Description
 * <p>
 * </p>
 * Date: 2017/7/26
 *
 * @author: 李伟健
 */
public class UserPo extends BasePo {

    private String username;

    private String password;

    private Short gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserPo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }
}
