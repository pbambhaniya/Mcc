package com.multipz.mcc.model;

/**
 * Created by Admin on 25-11-2017.
 */

public class ExpertInModel {

    int expert_in_id;
    String expertIn;
    boolean isSelected;

    public ExpertInModel(int expert_in_id, String expertIn, boolean isSelected) {
        this.expert_in_id = expert_in_id;
        this.expertIn = expertIn;
        this.isSelected = isSelected;
    }

    public int getExpert_in_id() {
        return expert_in_id;
    }

    public void setExpert_in_id(int expert_in_id) {
        this.expert_in_id = expert_in_id;
    }

    public String getExpertIn() {
        return expertIn;
    }

    public void setExpertIn(String expertIn) {
        this.expertIn = expertIn;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
