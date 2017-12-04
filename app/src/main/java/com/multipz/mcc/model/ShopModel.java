package com.multipz.mcc.model;

/**
 * Created by Admin on 27-11-2017.
 */

public class ShopModel {

    String name, image, desc;
    double rate;

    public ShopModel(String name, String image, String desc, double rate) {
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
