package service;

import model.WeatherData;

import java.util.ArrayList;
import java.util.Arrays;

public class StatisticsDisplay implements Observer, Display {
    private int[] temperature = new int[10];
    private int lastIndex = 1;
    private boolean isComplete = false;
    WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update() {
        temperature[lastIndex-1] = (int) weatherData.getTemperature();
        if(lastIndex<10)
            lastIndex += 1;
        else {
            lastIndex = 1;
            isComplete = true;
        }
        displayElements();
    }

    @Override
    public void displayElements() {
        if(isComplete==true)
            System.out.println("Avg/Max/Min temperature : "+
                                Arrays.stream(temperature).average().getAsDouble()+"/"+
                                Arrays.stream(temperature).max().getAsInt()+"/"+
                                Arrays.stream(temperature).min().getAsInt());
        else
            System.out.println("Avg/Max/Min temperature : "+
                    Arrays.stream(temperature).sum()/(lastIndex-1)+"/"+
                    Arrays.stream(temperature).max().getAsInt()+"/"+
                    Arrays.stream(temperature).min().getAsInt());
    }
}
