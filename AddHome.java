package org.taru.entity;

/**
 * 添加房源信息的综合实体类
 */
public class AddHome {
    private int homeId;
    private String homeName;
    private String homeAddress;
    private String homePrice;
    private String home_in_Date;
    private String home_out_date;
    private int landlord_id;

    public String getHome_in_Date() {
        return home_in_Date;
    }

    public void setHome_in_Date(String home_in_Date) {
        this.home_in_Date = home_in_Date;
    }

    public String getHome_out_date() {
        return home_out_date;
    }

    public void setHome_out_date(String home_out_date) {
        this.home_out_date = home_out_date;
    }

    private String homePicture;
    private String homeDescribe;
    private int homeStatus;

    public String getLandlordPhone() {
        return landlordPhone;
    }

    public void setLandlordPhone(String landlordPhone) {
        this.landlordPhone = landlordPhone;
    }

    private String picturesId;
    private String landlordName;
    private String landlordPhone;

    public String getPicturesId() {
        return picturesId;
    }

    public void setPicturesId(String picturesId) {
        this.picturesId = picturesId;
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

    public int getLanlordId() {
        return lanlordId;
    }

    public void setLanlordId(int lanlordId) {
        this.lanlordId = lanlordId;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordPhonr() {
        return landlordPhonr;
    }

    public void setLandlordPhonr(String landlordPhonr) {
        this.landlordPhonr = landlordPhonr;
    }

    public String getLandlordSex() {
        return landlordSex;
    }

    public void setLandlordSex(String landlordSex) {
        this.landlordSex = landlordSex;
    }

    public String getLandlordHeaderPicture() {
        return landlordHeaderPicture;
    }

    public void setLandlordHeaderPicture(String landlordHeaderPicture) {
        this.landlordHeaderPicture = landlordHeaderPicture;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public int getStyleStatus() {
        return styleStatus;
    }

    public void setStyleStatus(int styleStatus) {
        this.styleStatus = styleStatus;
    }

    private int discussId;
    private int styleId;

    public String getHomeConfigure() {
        return homeConfigure;
    }

    public void setHomeConfigure(String homeConfigure) {
        this.homeConfigure = homeConfigure;
    }

    private String homePraise;
    private String homeSpot;
    private int lanlordId;
    private String  landlordPhonr;
    private String landlordSex;
    private String landlordHeaderPicture;
    private String styleName;
    private int  styleStatus;
    private String homeConfigure;
}
