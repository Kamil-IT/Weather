package properties;

import models.Location;
import models.WeatherProperties;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

// TODO: make this as builder
public class WeatherPropertiesBuilder {
    private Location location;
    private String lang;
    private String weatherKey;
    private String geolocationKey;

    String PATH_PROPERTIES = "src/main/resources/properties/properties.json";

    /**
     * It get value of properties from filePath: PATH_PROPERTIES
     */
    public WeatherPropertiesBuilder propertiesFromFile(){
        ObjectMapper mapper = new ObjectMapper();
        File fileJson = new File(PATH_PROPERTIES);
        try {
            WeatherProperties properties = mapper.readValue(fileJson, WeatherProperties.class);
            this.weatherKey = properties.getWeatherKey();
            this.lang = properties.getLang();
            this.location = properties.getLocation();
            this.geolocationKey = properties.getGeolocationKey();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No entry or bad location to properties.json");
            System.out.println("You must set properties file to work weather ");
        }
        return this;
    }

    public WeatherPropertiesBuilder lang(String lang){
        this.lang = lang;
        return this;
    }

    public WeatherPropertiesBuilder location(Location location){
        this.location = location;
        return this;
    }

    public WeatherPropertiesBuilder weatherKey(String weatherKey){
        this.weatherKey = weatherKey;
        return this;
    }

    public WeatherPropertiesBuilder geolocation(String weatherKey){
        this.geolocationKey = weatherKey;
        return this;
    }

    public WeatherProperties build(){
        return new WeatherProperties(location, lang, weatherKey, geolocationKey);
    }
}
