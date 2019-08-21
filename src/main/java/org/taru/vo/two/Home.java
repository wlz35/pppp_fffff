package org.taru.vo.two;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 房屋表
 */
public class Home implements Serializable {
    private int homeId;
    private String homeName;
    private String homeAddress;
    private String homePrice;
    private int discussId;
    private int styleId;
    private String homePraise;
    private String homeSpot;
    private  String homeConfigure;
    /**
     * xiugai
     */
    private Date homeInDate;
    private Date homeOutDate;

    private int landlord_id;
    private String pictureId;
    private String homeDescribe;
    private int homeStatus;

    List<Discuss> discusses;
    Landlord landlords;
    List<Pictures> pictures;
//    private String reserveDate;


    public Date getHomeOutDate() {
        return homeOutDate;
    }

    public void setHomeOutDate(Date homeOutDate) {
        this.homeOutDate = homeOutDate;
    }

    public Date getHomeInDate() {
        return homeInDate;
    }

    public void setHomeInDate(Date homeInDate) {
        this.homeInDate = homeInDate;
    }

    public List<Pictures> getPictures() {
        return pictures;
    }

    public void setPictures(List<Pictures> pictures) {
        this.pictures = pictures;
    }

    public Landlord getLandlords() {
        return landlords;
    }

    public void setLandlords(Landlord landlords) {
        this.landlords = landlords;
    }



    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    Style style;





    public List<Discuss> getDiscusses() {
        return discusses;
    }

    public void setDiscusses(List<Discuss> discusses) {
        this.discusses = discusses;
    }



    public String getHomeConfigure() {
        return homeConfigure;
    }

    public void setHomeConfigure(String homeConfigure) {
        this.homeConfigure = homeConfigure;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

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

//    public String getReserveDate() {
//        return reserveDate;
//    }
//
//    public void setReserveDate(String reserveDate) {
//        this.reserveDate = reserveDate;
//    }

    public int getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(int landlord_id) {
        this.landlord_id = landlord_id;
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


}