package org.taru.vo.one;

import org.taru.entity.Landlord;


import java.util.List;

public class Storyss {
    private String storyId;
    private String picturesId;
    private String storyTitle;
    private String storyDiscrible;
    private String userId;
    private String storyStatus;
    private String storyCity;
    private String storyLikes;
    private String landlordId;
    private Pictures pictures;
    private List<Landlord> landlord;
    private List<Discuss> discusses;
    private List<User> user;

    public List<Discuss> getDiscusses() {
        return discusses;
    }

    public void setDiscusses(List<Discuss> discusses) {
        this.discusses = discusses;
    }
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Landlord> getLandlord() {
        return landlord;
    }

    public void setLandlord(List<Landlord> landlord) {
        this.landlord = landlord;
    }







    public String getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(String landlordId) {
        this.landlordId = landlordId;
    }

    public Pictures getPictures() {
        return pictures;
    }

    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getPicturesId() {
        return picturesId;
    }

    public void setPicturesId(String picturesId) {
        this.picturesId = picturesId;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryDiscrible() {
        return storyDiscrible;
    }

    public void setStoryDiscrible(String storyDiscrible) {
        this.storyDiscrible = storyDiscrible;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoryStatus() {
        return storyStatus;
    }

    public void setStoryStatus(String storyStatus) {
        this.storyStatus = storyStatus;
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




}
