package com.example.ResfulAPIdemo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

// This object acts as the storage for the ID of the sensor as well as its country and city
// This is an object which can be later replaced with a handler which would send information to and from a database
// This also stores the arraylist of metrics which it has collected with each update
public class Sensor {

    private long sid = 0;
    private String country;
    private String city;


    public Sensor(long incrementAndGet, String country, String city) {
        sid = incrementAndGet;
        this.country = country;
        this.city = city;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private DateStorage storagepoint = new DateStorage();

    public void addPoint(String temperature, String humidity){
        storagepoint.addMetric(temperature, humidity);
    }

    public DateStorage getStoragePoint(){
        return storagepoint;
    }
}
