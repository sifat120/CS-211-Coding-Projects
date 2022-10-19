/*
Project 2 - Weather App & Google Maps API
Name: Sifat Hasan
ID: 202887233
Date: 10/18/2022
Project Description: This project utilizes the weather app &
Google Maps apis to display weather information and the map of
an inputted city.
Class Description: This class utilizes the Google Maps
embed api in order to display the map of a given city
name. Output is produced in "myMap.html"
 */

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Map211 {
    private static String html;
    private static String weather;
    private static String mapFileName="myMap.html";

    Map211 (ArrayList<String> weatherInfo, String mapType, int zoom) throws IOException {
        String city=weatherInfo.get(0);
        // Create a single string data using weatherInfo
        // eg) BELLEVUE | clear sky | temp: 80.6° | low: 72.2° | high: 84.7° | wind: 3.5mph | humidity: 56% |
        weather= " "+city.toUpperCase()+"   | " /* + . . . . . */ ;
        // write a HTML file
        writeHTML(weather,city, mapType, zoom);
        // run html file from java code
        String url = mapFileName;   // you can find this html file in the project folder
        File htmlFile = new File(url);
        Desktop.getDesktop().browse(htmlFile.toURI());
    }

    public static void writeHTML(String weatherNow, String city, String mapType, int zoom) {
        html="<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>"
                + weatherNow
                + "</h2>"
                + "<iframe"
                + "  width=1200"
                + "  height=900"
                + "  style=border:0"
                + "  loading=lazy"
                + "  allowfullscreen"
                + "  referrerpolicy=\"no-referrer-when-downgrade\""
                + "src=\"https://www.google.com/maps/embed/v1/place?key=AIzaSyC8ypb3fJkTGsp0yyE8atqkTKeDvdcY2xs&q="+ city +"&zoom="+ zoom
                +"&maptype=" + mapType+"\""
                + "</iframe>"
                + "</body>"
                + "</html>";
        File f= new File (mapFileName);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(html);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
