package models;

import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;
import properties.WeatherPropertiesBuilder;
import service.JOpenCageGeocoderClient;

public class Location {
    private String city;
    private String country;
    private double latitude;
    private double longitude;

    @SuppressWarnings("Mapper need this")
    public Location() {
    }

    public Location(String city, String country) {
        this.city = city;
        this.country = country;

        //        TODO: must change value of latitude and value of longitude
    }

    /**
     * It's a constructor witch set name of city and country by longitude and latitude
     */
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;

        this.setCountyCityByGeoLocation();
    }

    /**
     * It's a function witch set name of city and country by longitude and latitude and
     * Set latitude and longitude
     */
    public void setGeoCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;

        this.setCountyCityByGeoLocation();
    }

    public void setCountryCity(String country, String city, String lang) {
//        TODO: Check value if exists in real word
//        TODO: Set the latitude and longitude
        this.country = country;
        this.city = city;

    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * This function set city name and country name by latitude and longitude
     */
    private void setCountyCityByGeoLocation() {
        WeatherProperties properties = new WeatherPropertiesBuilder().propertiesFromFile().build();

        JOpenCageGeocoderClient jOpenCageGeocoderClient = new JOpenCageGeocoderClient(properties.getGeolocationKey());

        JOpenCageReverseRequest request = new JOpenCageReverseRequest(this.latitude, this.longitude);
        request.setNoAnnotations(true);
        request.setLanguage(properties.getLang());

        JOpenCageResponse response = jOpenCageGeocoderClient.reverse(request);

        this.city = response.getResults().get(0).getComponents().getCity();
        this.country = response.getResults().get(0).getComponents().getCountry();
    }
}
