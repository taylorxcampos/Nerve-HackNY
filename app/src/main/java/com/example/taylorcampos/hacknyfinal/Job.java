package com.example.taylorcampos.hacknyfinal;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taylorcampos on 4/8/17.
 */

@IgnoreExtraProperties
public class Job {


    public Job(){

    }
    private String title;
    private String companyName;
    private String location;
    private String partOrFull;
    private String description;

    private Map<String, Object> mp;

    public Job(String t, String cn, String l, String p, String d)
    {
        this.title = t;
        this.companyName = cn;
        this.location = l;
        this.partOrFull = p;
        this.description = d;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPartOrFull() {
        return partOrFull;
    }

    public void setPartOrFull(String partOrFull) {
        this.partOrFull = partOrFull;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Exclude
    public Map<String, Object> toMap()
    {
        mp = new HashMap<>();
        mp.put("title", this.title);
        mp.put("companyName", this.companyName);
        mp.put("location" ,this.location);
        mp.put("partOrFull", this.partOrFull);
        mp.put("location", this.location);
        mp.put("description", this.description);

        return mp;
    }
}
