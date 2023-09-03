package com.example.practice.first;

public class Actions {
    String action_id, user_id, date, description, device_id, version;
    public Actions(String action_id,String user_id,String date,String description,String device_id,String version){
        this.action_id = action_id;
        this.user_id = user_id;
        this.date = date;
        this.description = description;
        this.device_id = device_id;
        this.version = version;
    }

    public String getAction_id() {
        return action_id;
    }

    public void setAction_id(String action_id) {
        this.action_id = action_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
