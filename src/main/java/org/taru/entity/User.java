package org.taru.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表
 */
public class User implements Serializable {
private int userId;
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserHeaderPicture() {
        return userHeaderPicture;
    }

    public void setUserHeaderPicture(String userHeaderPicture) {
        this.userHeaderPicture = userHeaderPicture;
    }

    private String userName;
private String passWord;
private  String sex;
private String email;
private String phone;
private String userHeaderPicture;

}