package com.example.ResfulAPIdemo;

import java.time.LocalDate;
import java.time.LocalDateTime;

//  This object serves as the storage and source of each individual measurement of temperature and humidity
//  This object can be later replaced by a handler which can be directed to send information to and from a database
public class Metrics {

    private final String temperature;
    private final String humidity;
    private final LocalDateTime datetime = LocalDateTime.now();

    public Metrics(String temperature, String humidity){
        this.temperature = temperature;
        this.humidity = humidity;

    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }
}
