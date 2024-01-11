package run;

import model.WeatherData;
import service.CurrentConditionDisplay;
import service.ForcastDisplay;
import service.StatisticsDisplay;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForcastDisplay forcastDisplay = new ForcastDisplay(weatherData);

        weatherData.setMeasurements(25, 50, 20.3f);
        weatherData.setMeasurements(27, 55, 22.4f);
        weatherData.setMeasurements(24, 60, 19.4f);
    }
}
