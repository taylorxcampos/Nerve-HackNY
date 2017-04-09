package com.example.taylorcampos.hacknyfinal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taylorcampos on 4/8/17.
 */

public class Service {

    private String service;
    private String companyName;
    private String date;
    private String time;
    private String location;
    private String description;

    private Map<String, Object> mp;

    public Service(){

    }
    public Service(String service, String companyName, String date, String time, String location, String description)
    {
        this.service = service;
        this.companyName = companyName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;

    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Map<String, Object> toMap()
    {
        mp = new HashMap<>();
        mp.put("service", this.service);
        mp.put("companyName", this.companyName);
        mp.put("date" ,this.date);
        mp.put("time", this.time);
        mp.put("location", this.location);
        mp.put("description", this.description);

        return mp;
    }
}
