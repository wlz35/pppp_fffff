package org.taru.entity;

import java.util.List;

public class DIscussHomeVo {
    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    public String getDiscussText() {
        return discussText;
    }

    public void setDiscussText(String discussText) {
        this.discussText = discussText;
    }

    public String getDiscussDate() {
        return discussDate;
    }

    public void setDiscussDate(String discussDate) {
        this.discussDate = discussDate;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public int getDiscussStatus() {
        return discussStatus;
    }

    public void setDiscussStatus(int discussStatus) {
        this.discussStatus = discussStatus;
    }

    private int discussId;
    private String discussText;
    private String discussDate;
    private int homeId;
    private int discussStatus;

    public List<Home> getList() {
        return list;
    }

    public void setList(List<Home> list) {
        this.list = list;
    }

    private List<Home> list;
}
