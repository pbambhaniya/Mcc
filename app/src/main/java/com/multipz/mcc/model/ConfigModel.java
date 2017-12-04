package com.multipz.mcc.model;

/**
 * Created by Admin on 29-11-2017.
 */

public class ConfigModel {

    public int mainId, subId;
    public String name;

    public ConfigModel() {
    }

    public ConfigModel(int mainId, String name) {
        this.mainId = mainId;
        this.name = name;
    }

    public ConfigModel(int mainId, int subId, String name) {
        this.mainId = mainId;
        this.subId = subId;
        this.name = name;
    }

    public int getMainId() {
        return mainId;
    }

    public void setMainId(int mainId) {
        this.mainId = mainId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
