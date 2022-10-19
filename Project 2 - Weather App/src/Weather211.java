/*
Project 2 - Weather App & Google Maps API
Name: Sifat Hasan
ID: 202887233
Date: 10/18/2022
Project Description: This project utilizes the weather app &
Google Maps apis to display weather information and the map of
an inputted city.
Class Description: This class utilizes the weather api and
displays weather information given a city name.
*/

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Weather211 {

    private static ArrayList<String> weatherInfo = new ArrayList<>();

    public static boolean CityWeather (String cityName) throws Exception {
        boolean validCityName = true;
        try {
            //Create a URL instance
            String firstPartURL = "https://api.openweathermap.org/data/2.5/weather?q=";
            String secondPartURL = "&appid=744b6a04f866cfa37688705b54850afc";
            String theURL = firstPartURL + cityName + secondPartURL;
            URL url = new URL(theURL);
            //Reads information from URL
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            //JSON parser object to parse read file
            JSONParser jsonParser = new JSONParser();
            //Read JSON file. All the data for the city is stored in "myObject"
            JSONObject myObject = (JSONObject) jsonParser.parse(br);

            // 1. add city name to the data structure
            weatherInfo.add(cityName);

            // 2. Weather
            JSONArray weatherArray = (JSONArray) myObject.get("weather");
            JSONObject w = (JSONObject) weatherArray.get(0);
            // get weather info from w
            String weatherNow = (String) w.get("description");
            // add weather info to the data structure (see 1. add city name...  above)
            weatherInfo.add(weatherNow);

            // 3. Temp
            // get temp from myObject
            JSONObject main = (JSONObject) myObject.get("main");
            double cityTemp = (double) main.get("temp");
            cityTemp = kelvinToFahrenheit(cityTemp); //convert to Fahrenheit
            String tempNow = "temp: " + String.format("%.1f", cityTemp) + "\u00B0";
            // add temp to the data structure
            weatherInfo.add(tempNow);

            // 4. Temp_min
            // get temp_min from myObject
            double cityTempMin = (double) main.get("temp_min");
            cityTempMin = kelvinToFahrenheit(cityTempMin); //convert to Fahrenheit
            String tempLow = "low: " + String.format("%.1f", cityTempMin) + "\u00B0";
            // add temp_min to the data structure
            weatherInfo.add(tempLow);

            // 5. Temp_max
            // get temp_max from myObject
            double cityTempMax = (double) main.get("temp_max");
            cityTempMax = kelvinToFahrenheit(cityTempMax); //convert to Fahrenheit
            String tempHigh = "high: "+String.format("%.1f", cityTempMax)+"\u00B0";
            // add temp_max to the data structure
            weatherInfo.add(tempHigh);

            // 6. Wind
            // get wind speed from myObject
            JSONObject wind = (JSONObject) myObject.get("wind");
            double windSpeed = (double) wind.get("speed");
            String windStr = "wind: " + windSpeed + "mph";
            // add wind speed to the data structure
            weatherInfo.add(windStr);

            // 7. Humidity
            // get humidity from myObject
            long humidity = (long) main.get("humidity");
            String humidityStr = "humidity: " + humidity + "%";
            // add humidity to the data structure
            weatherInfo.add(humidityStr);
        } catch (Exception e) {
            validCityName = false;

        }
        return validCityName;
    }

    private static double kelvinToFahrenheit(double num) {
        return ((num - 273.15)*9)/5 + 32;
    }

    public static ArrayList<String> getCityWeatherNow() {
        return weatherInfo;
    }
}