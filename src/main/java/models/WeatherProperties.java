package models;

import org.codehaus.jackson.annotate.JsonProperty;

public class WeatherProperties {
    private Location location;
    private String lang;
    private String weatherKey;
    private String geolocationKey;

    /**
     * Mapper need it
     */
    public WeatherProperties() {

    }

    /**
     * This constructor update file: properties.json
     * @param location weather location
     * @param lang side language
     * @param weatherKey key to dark sky api
     * @param geolocationKey key to open cage data
     */
    public WeatherProperties(Location location, String lang, String weatherKey, String geolocationKey) {
        this.location = location;
        this.lang = lang;
        this.weatherKey = weatherKey;
        this.geolocationKey = geolocationKey;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("language")
    public String getLang() {
        return lang;
    }

    @JsonProperty("language")
    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getWeatherKey() {
        return weatherKey;
    }

    public void setWeatherKey(String weatherKey) {
        this.weatherKey = weatherKey;
    }

    public String getGeolocationKey() { return geolocationKey; }

    public void setGeolocationKey(String geolocationKey) { this.geolocationKey = geolocationKey; }
}
