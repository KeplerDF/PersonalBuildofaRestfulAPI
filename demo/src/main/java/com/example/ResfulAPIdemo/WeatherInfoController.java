package com.example.ResfulAPIdemo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

/*
   This is the main and in this project only controller for this project.
   I have made the decision to do this in order to keep it less complex overall as well as less time-consuming to manage

 */
@RestController
public class WeatherInfoController{

    private final AtomicLong counter = new AtomicLong();
    private ArrayList<Sensor> sensorlist = new ArrayList<>();

    //  This method acts as the first call to be made when creating a sensor
    //  It initialises the sensor with whichever country and city you give as well as having default values in case neither country or city is given
    //  The ID is given automatically with a global counter
    //  This method returns a Sensor object which is then output on the localhost as a JSON file format due to the automated pathing provided by Spring
    // I chose JSON files because they were already available as well as my limited experience with them
    @RequestMapping("/sensor")
    public Sensor sensor(@RequestParam(value = "country", defaultValue = "Unspecified") String country,
                         @RequestParam(value = "city", defaultValue = "Unspecified") String city)
    {
        sensorlist.add( new Sensor(counter.incrementAndGet(),  country, city ));
        return new Sensor(counter.get(),  country, city );
    }
    
    //  This is the 3rd request in the README file and it is meant to return the average of all metrics between the two dates you provide from whichever sensor you specify 
    //  This currently doesnt have intentional multi sejnsor integration as I found it dificult to implemet and would prefer to get the logic for the singular right before
    //  I tried my hand at that.
    //  This method deos cause an error as I have explained in my README however it is intended to return a rudamentary object of type metric which will have the average of 
    //  the temperatures as well as the average of the humidities.
    //  Unfortunatly the metrics object does also return the current time as it is part of the object however because the metric object is only a temperary storage in place
    //  of a server handler I did not see this as a major issue yet.
    @GetMapping("/infogetter")
    public Metrics infoGetter(@RequestParam(value = "sensorid", defaultValue = "Unspecified") String sensorid,
                                        @RequestParam(value = "timestart", defaultValue = "Unspecified") String timestart,
                                        @RequestParam(value = "timeend", defaultValue = "Unspecified") String timeend)
    {
        ArrayList<Metrics> averages;

        int numberofdates = 1;
        int totaltemp = 0;
        int totalhumid = 0;
        LocalDateTime starttime = LocalDateTime.parse(timestart);
        LocalDateTime endtime = LocalDateTime.parse(timeend);

        for(int j = 0; j < sensorlist.size(); j++){
            Sensor bob = sensorlist.get(j);
            if(bob.getSid() == Long.parseLong(sensorid)){
                averages = bob.getStoragePoint().getMetriclist();
                System.out.println(averages.get(j));
                System.out.println(averages.get(j).getDatetime());

                if( starttime.isBefore(averages.get(j).getDatetime()) && endtime.isAfter(averages.get(j).getDatetime())){
                    totaltemp += Integer.parseInt(averages.get(j).getTemperature());
                    totalhumid += Integer.parseInt(averages.get(j).getHumidity());
                    numberofdates++;
                }
            }
        }
        Metrics result = new Metrics(String.valueOf(totaltemp/numberofdates), String.valueOf(totalhumid/numberofdates));
        return result;


    }

    //  This method serves to update the specified sensor with a reading, currently given by manual input however this can later be made to be an automated call from
    //  the frontend implementation. 
    //  I have wrapped this methode's contents in a try-catch statment as an example of what should be standard for the other methods in this class as well. 
    @RequestMapping("/update")
    public void updatesensor(@RequestParam(value = "sensorid", defaultValue = "0") String sensorid,
                             @RequestParam(value = "temperature", defaultValue = "Unspecified") String temperature,
                             @RequestParam(value = "humidity", defaultValue = "Unspecified") String humidity)
    {

        try{
            sensorlist.get(Integer.parseInt(sensorid)).addPoint(temperature, humidity);
        }catch( Exception e){
            System.out.println("This program could not find this index: " + e.toString());
        }

    }


}

