package org.taru.entity;

import java.io.Serializable;

/**
 * 订单表
 */
public class Order implements Serializable {
    private int orderId;
    private  int homeId;
    private User user;
    private String homeName;

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getHomePrice() {
        return homePrice;
    }

    public void setHomePrice(String homePrice) {
        this.homePrice = homePrice;
    }

    public String getPicTure() {
        return picTure;
    }

    public void setPicTure(String picTure) {
        this.picTure = picTure;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    private String homePrice;
    private String picTure;
    private String homeAddress;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderUserIndate() {
        return orderUserIndate;
    }

    public void setOrderUserIndate(String orderUserIndate) {
        this.orderUserIndate = orderUserIndate;
    }

    public String getOrderOutdate() {
        return orderOutdate;
    }

    public void setOrderOutdate(String orderOutdate) {
        this.orderOutdate = orderOutdate;
    }

    private int userId;
    private String orderPrice;
    private int orderStatus;
    private String orderUserIndate;
    private String orderOutdate;
}
