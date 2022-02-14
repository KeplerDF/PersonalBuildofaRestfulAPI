package com.example.ResfulAPIdemo;

import java.util.ArrayList;

public class DateStorage {

    private ArrayList<Metrics> metriclist = new ArrayList<>();

    public DateStorage(){
    }

    public void addMetric(String temperature, String humidity){
        Metrics met = new Metrics(temperature,humidity);
        metriclist.add(met);
    }

    public ArrayList<Metrics> getMetriclist(){

        return metriclist;
    }
}
