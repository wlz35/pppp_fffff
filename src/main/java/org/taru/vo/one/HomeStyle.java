package org.taru.vo.one;

import org.taru.entity.Style;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 房屋表
 */
public class HomeStyle implements Serializable {
    private int homeId;
    private String homeName;
    private String homeAddress;
    private String homePrice;
    private int discussId;
    private int styleId;
    private String homePraise;
    private String homeSpot;
    private  String homeConfigure;
    private String homeInDate;

    public String getHomeInDate() {
        return homeInDate;
    }

    public void setHomeInDate(String homeInDate) {
        this.homeInDate = homeInDate;
    }

    public String getHomeOutDate() {
        return homeOutDate;
    }

    public void setHomeOutDate(String homeOutDate) {
        this.homeOutDate = homeOutDate;
    }

    private String homeOutDate;

    private int landlord_id;
    private String pictureId;
    private String homeDescribe;
    private int homeStatus;
    private List<Style> style;

    public Pictures getPictures() {
        return pictures;
    }

    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }

    private Pictures pictures;

    public List<Style> getStyle() {
        return style;
    }

    public void setStyle(List<Style> style) {
        this.style = style;
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
