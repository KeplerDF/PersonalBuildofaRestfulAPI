package com.example.ResfulAPIdemo;

import java.util.ArrayList;

/*
    This object exists to store the metrics in a much more managable object. 
    This is done because one sensor can have many instances of metrics so this was built to contain every instance but in a more managable format
*/

public class DateStorage {

    private ArrayList<Metrics> metriclist = new ArrayList<>();

    public DateStorage(){
    }
    
//  This adds a new metric to the Arraylist
    public void addMetric(String temperature, String humidity){
        Metrics met = new Metrics(temperature,humidity);
        metriclist.add(met);
    }
    
//  Returns the entire arraylist
    public ArrayList<Metrics> getMetriclist(){

        return metriclist;
    }
}
