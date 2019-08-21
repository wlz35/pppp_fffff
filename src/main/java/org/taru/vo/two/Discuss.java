package org.taru.vo.two;

import java.io.Serializable;

/**
 * 评论表
 */
public class Discuss implements Serializable {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private int discussId;
    private String discussText;
    private String discussDate;
    private int homeId;
    private int discussStatus;
    User user;




}
