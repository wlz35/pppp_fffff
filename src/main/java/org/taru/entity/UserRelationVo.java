package org.taru.entity;

public class UserRelationVo {
    private int relationId;

    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodFrientId() {
        return goodFrientId;
    }

    public void setGoodFrientId(int goodFrientId) {
        this.goodFrientId = goodFrientId;
    }

    private int userId;
    private int goodFrientId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
}
