package service;

import model.WeatherData;

import java.util.ArrayList;

public class ForcastDisplay implements Observer, Display {
    private float curretPressure;
    private float lastPressure;
    private WeatherData weatherData;

    public ForcastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update() {
        lastPressure = curretPressure;
        curretPressure = weatherData.getPressure();
        displayElements();
    }

    @Override
    public void displayElements() {
        if (curretPressure > lastPressure)
            System.out.println("Improving weather on the way");
        else if (curretPressure < lastPressure)
            System.out.println("Watch out for cooler, rainy weather");
        else
            System.out.println("More of the same");
    }
}
