package com.multipz.mcc.model;

/**
 * Created by Admin on 25-11-2017.
 */

public class NotificationModel {

    String image, title, time;

    public NotificationModel(String image, String title, String time) {
        this.image = image;
        this.title = title;
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
