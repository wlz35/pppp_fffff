package org.taru.entity;

import java.io.Serializable;

/**
 * 房东信息表
 */
public class Landlord implements Serializable {
    private int lanlordId;

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

    private String landlordName;
    private String  landlordPhonr;
    private String landlordSex;
    private String landlordHeaderPicture;
}
