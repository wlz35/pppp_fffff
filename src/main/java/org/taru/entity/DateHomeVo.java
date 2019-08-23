package org.taru.entity;

public class DateHomeVo {
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

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(String closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getBeginningPrice() {
        return BeginningPrice;
    }

    public void setBeginningPrice(String beginningPrice) {
        BeginningPrice = beginningPrice;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    private String homeOutDate;
    private String styleName;
    private String homeAddress;
    private String closingPrice;
    private String BeginningPrice;
    private int pageNum;
    private int  pageSize;

}
