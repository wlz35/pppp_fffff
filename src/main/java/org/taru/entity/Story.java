package org.taru.entity;

public class Story {
    private int storyId;
    private int picturesId;
    private String storyTitle;
    private String storyDiscribe;
    private int userId;

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public int getPicturesId() {
        return picturesId;
    }

    public void setPicturesId(int picturesId) {
        this.picturesId = picturesId;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryDiscribe() {
        return storyDiscribe;
    }

    public void setStoryDiscribe(String storyDiscribe) {
        this.storyDiscribe = storyDiscribe;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStoryCity() {
        return storyCity;
    }

    public void setStoryCity(String storyCity) {
        this.storyCity = storyCity;
    }

    public String getStoryLikes() {
        return storyLikes;
    }

    public void setStoryLikes(String storyLikes) {
        this.storyLikes = storyLikes;
    }

    private int status;
    private String storyCity;
    private String storyLikes;
}
