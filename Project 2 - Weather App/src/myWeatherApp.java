/*
Project 2 - Weather App & Google Maps API
Name: Sifat Hasan
ID: 202887233
Date: 10/18/2022
Project Description: This project utilizes the weather app &
Google Maps apis to display weather information and the map of
an inputted city.
Class Description: This is the main class, where everything comes
together. This is where we handle all console inputs and call the
other method/class functions.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class myWeatherApp {
    static Scanner console = new Scanner(System.in);
    private static ArrayList<String> weatherInfo = new ArrayList<>();
    static String mapType;
    static int zoom;

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Weather 211 - Fall 2022");
        System.out.println();

        // ask user for inputs
        inputCityName();
    }

    public static void getWeatherInfo() throws Exception {
        weatherInfo=Weather211.getCityWeatherNow();

        // print text version
        for (int i=0; i<weatherInfo.size(); i++) {
            System.out.println(weatherInfo.get(i));
        }

        // call Map211
        new Map211(weatherInfo, mapType, zoom);
    }

    public static void inputCityName() throws Exception {
        boolean validCityName=false;
        while (!validCityName) {

            System.out.print("Input a city name: ");
            String city = console.nextLine();
            System.out.println();

            boolean valid = Weather211.CityWeather(city);

            if (valid) {
                // ask for map type (roadmap, satellite)
                System.out.println("Select map type: 1) roadmap 2) satellite");
                int mapNum = console.nextInt();
                if(mapNum == 1) {
                    mapType = "roadmap";
                }
                else if(mapNum == 2) {
                    mapType = "satellite";
                }
                else {
                    throw new IllegalArgumentException();
                }
                // ask for zoom level (0~21)
                System.out.println("Select zoom level of the map: 0 ~ 21 (default=14)");
                zoom = console.nextInt();
                System.out.println("Current Weather [" + city +"]\n");
                getWeatherInfo();
                break;
            } else {
                System.out.println("Invalid city name. Type again.\n");
            }
        }
    }
}