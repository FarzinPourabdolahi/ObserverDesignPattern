package service;

import model.WeatherData;

import java.util.ArrayList;

public class CurrentConditionDisplay implements Observer, Display {

    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        displayElements();
    }

    @Override
    public void displayElements() {
        System.out.println("Current conditions : " + temperature + " C degrees and " + humidity + "% humidity");
    }
}
