package service;

import models.WeatherProperties;
import tk.plogitech.darksky.api.jackson.DarkSkyJacksonClient;
import tk.plogitech.darksky.forecast.APIKey;
import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder;
import tk.plogitech.darksky.forecast.GeoCoordinates;
import tk.plogitech.darksky.forecast.model.Forecast;
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;

public class ForecastRequestClient {

    private WeatherProperties properties;
    private Forecast forecast;

    /**
     * @param properties properties for weather
     */
    public ForecastRequestClient(WeatherProperties properties) {
        this.properties = properties;
        tk.plogitech.darksky.forecast.ForecastRequest request = (new ForecastRequestBuilder())
                .key(
                        new APIKey(
                                properties.getWeatherKey()))
                .location(
                        new GeoCoordinates(
                                new Longitude(properties.getLocation().getLongitude()),
                                new Latitude(properties.getLocation().getLatitude())
                        ))
                .language(
                        ForecastRequestBuilder.Language.valueOf(
                                properties.getLang()))
                .build();

        DarkSkyJacksonClient client = new DarkSkyJacksonClient();
        try {
            this.forecast = client.forecast(request);
        } catch (ForecastException e) {
            e.printStackTrace();
        }


    }

    /**
     * Create witch default non parameter constructor for WeatherProperties
     */
    public ForecastRequestClient() {
        this.properties = new WeatherProperties();
        tk.plogitech.darksky.forecast.ForecastRequest request = (new ForecastRequestBuilder())
                .key(
                        new APIKey(
                                properties.getWeatherKey()))
                .location(
                        new GeoCoordinates(
                                new Longitude(properties.getLocation().getLongitude()),
                                new Latitude(properties.getLocation().getLatitude())
                        ))
                .language(
                        ForecastRequestBuilder.Language.valueOf(
                                properties.getLang()))
                .build();

        DarkSkyJacksonClient client = new DarkSkyJacksonClient();
        try {
            this.forecast = client.forecast(request);
        } catch (ForecastException e) {
            e.printStackTrace();
        }

    }

    public Forecast getForecast() {
        return forecast;
    }

    public WeatherProperties getProperties() {
        return properties;
    }

    public void setProperties(WeatherProperties properties) {
        this.properties = properties;
    }
}
