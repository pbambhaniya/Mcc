package com.multipz.mcc.model;

/**
 * Created by Admin on 25-11-2017.
 */

public class FeedsModel {

    int feedId;
    String img_dp, img_post, name, time, like;

    public FeedsModel(int feedId, String img_dp, String img_post, String name, String time, String like) {
        this.feedId = feedId;
        this.img_dp = img_dp;
        this.img_post = img_post;
        this.name = name;
        this.time = time;
        this.like = like;
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public String getImg_dp() {
        return img_dp;
    }

    public void setImg_dp(String img_dp) {
        this.img_dp = img_dp;
    }

    public String getImg_post() {
        return img_post;
    }

    public void setImg_post(String img_post) {
        this.img_post = img_post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
