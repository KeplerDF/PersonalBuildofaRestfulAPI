package com.example.ResfulAPIdemo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherInfoController{

    private final AtomicLong counter = new AtomicLong();
    private ArrayList<Sensor> sensorlist = new ArrayList<>();

    @RequestMapping("/sensor")
    public Sensor sensor(@RequestParam(value = "country", defaultValue = "Unspecified") String country,
                         @RequestParam(value = "city", defaultValue = "Unspecified") String city)
    {
        sensorlist.add( new Sensor(counter.incrementAndGet(),  country, city ));
        return new Sensor(counter.get(),  country, city );
    }

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

