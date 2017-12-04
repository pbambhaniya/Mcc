package com.multipz.mcc.model;

/**
 * Created by Admin on 27-11-2017.
 */

public class PreferencesModel {

    String title;
    boolean isChecked;

    public PreferencesModel(String title, boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
