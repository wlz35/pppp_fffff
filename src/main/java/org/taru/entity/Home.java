package org.taru.entity;

import java.io.Serializable;

/**
 * 房屋表
 */
public class Home implements Serializable {
    private int homeId;

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomePrice() {
        return homePrice;
    }

    public void setHomePrice(String homePrice) {
        this.homePrice = homePrice;
    }


    public int getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(int landlord_id) {
        this.landlord_id = landlord_id;
    }

    public String getHomePicture() {
        return homePicture;
    }

    public void setHomePicture(String homePicture) {
        this.homePicture = homePicture;
    }

    public String getHomeDescribe() {
        return homeDescribe;
    }

    public void setHomeDescribe(String homeDescribe) {
        this.homeDescribe = homeDescribe;
    }

    public int getHomeStatus() {
        return homeStatus;
    }

    public void setHomeStatus(int homeStatus) {
        this.homeStatus = homeStatus;
    }

    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public String getHomePraise() {
        return homePraise;
    }

    public void setHomePraise(String homePraise) {
        this.homePraise = homePraise;
    }

    public String getHomeSpot() {
        return homeSpot;
    }

    public void setHomeSpot(String homeSpot) {
        this.homeSpot = homeSpot;
    }

    private String homeName;
    private String homeAddress;
    private String homePrice;
    private String homeInDate;

    public String gethomeInDate() {
        return homeInDate;
    }

    public void sethomeInDate(String homeInDate) {
        this.homeInDate = homeInDate;
    }

    public String getHomeOutDate() {
        return homeOutDate;
    }

    public void setHomeOutDate(String homeOutDate) {
        this.homeOutDate = homeOutDate;
    }

    private  String homeOutDate;
    private int landlord_id;
    private String homePicture;
    private String homeDescribe;
    private int homeStatus;
    private int discussId;
    private int styleId;
    private String homePraise;
    private String homeSpot;

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getHomeConfigure() {
        return homeConfigure;
    }

    public void setHomeConfigure(String homeConfigure) {
        this.homeConfigure = homeConfigure;
    }

    private String pictureId;
    private String homeConfigure;
}
