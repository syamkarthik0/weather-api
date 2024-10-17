package com.example.Weather_App;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    public String getWeatherData(String location) {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&units=imperial&appid=%s", location, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
    
}
