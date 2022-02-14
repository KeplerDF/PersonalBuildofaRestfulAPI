package com.example.ResfulAPIdemo;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
