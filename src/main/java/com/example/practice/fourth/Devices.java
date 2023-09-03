package com.example.practice.fourth;

public class Devices {
    String udid, name, model, systemname, devicemodel, deviceversion, physicalmemory, versionapp;

    public Devices(String udid, String name, String model, String systemname, String devicemodel,
                   String deviceversion, String physicalmemory, String versionapp) {
        this.udid = udid;
        this.name = name;
        this.model = model;
        this.systemname = systemname;
        this.devicemodel = devicemodel;
        this.deviceversion = deviceversion;
        this.physicalmemory = physicalmemory;
        this.versionapp = versionapp;
    }

    public String getUdid() {
        return udid;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getSystemname() {
        return systemname;
    }

    public String getDevicemodel() {
        return devicemodel;
    }

    public String getDeviceversion() {
        return deviceversion;
    }

    public String getPhysicalmemory() {
        return physicalmemory;
    }

    public String getVersionapp() {
        return versionapp;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSystemname(String systemname) {
        this.systemname = systemname;
    }

    public void setDevicemodel(String devicemodel) {
        this.devicemodel = devicemodel;
    }

    public void setDeviceversion(String deviceversion) {
        this.deviceversion = deviceversion;
    }

    public void setPhysicalmemory(String physicalmemory) {
        this.physicalmemory = physicalmemory;
    }

    public void setVersionapp(String versionapp) {
        this.versionapp = versionapp;
    }
}
