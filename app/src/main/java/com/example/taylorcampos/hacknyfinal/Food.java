package com.example.taylorcampos.hacknyfinal;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by taylorcampos on 4/8/17.
 */
@IgnoreExtraProperties
public class Food {
    public Food(){

    }

    private Map<String, Object> mp;

    private String type;
    private String companyName;
    private String date;
    private String time;
    private String location;
    private String description;

    public Food(String type, String companyName, String date, String time, String location, String description)
    {
        this.type = type;
        this.companyName = companyName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        mp = new HashMap<String, Object>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Exclude
    public Map<String, Object> toMap()
    {
        mp.put("type", this.type);
        mp.put("companyName", this.companyName);
        mp.put("date" ,this.date);
        mp.put("time", this.time);
        mp.put("location", this.location);
        mp.put("description", this.description);

        return mp;
    }
    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
}
