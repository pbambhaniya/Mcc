package com.multipz.mcc.model;

/**
 * Created by Admin on 25-11-2017.
 */

public class ExpertModel {

    int expert_in_id;
    String image, name, expertIn, experiense;
    boolean isFollow;

    public ExpertModel(int expert_in_id, String image, String name, String expertIn, String experiense, boolean isFollow) {
        this.expert_in_id = expert_in_id;
        this.image = image;
        this.name = name;
        this.expertIn = expertIn;
        this.experiense = experiense;
        this.isFollow = isFollow;
    }

    public int getExpert_in_id() {
        return expert_in_id;
    }

    public void setExpert_in_id(int expert_in_id) {
        this.expert_in_id = expert_in_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertIn() {
        return expertIn;
    }

    public void setExpertIn(String expertIn) {
        this.expertIn = expertIn;
    }

    public String getExperiense() {
        return experiense;
    }

    public void setExperiense(String experiense) {
        this.experiense = experiense;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }
}
