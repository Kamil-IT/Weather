import properties.WeatherPropertiesBuilder;
import models.WeatherProperties;
import service.ForecastRequestClient;
import tk.plogitech.darksky.forecast.model.Forecast;
import ui.FormMain;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

//        Example: How to use
        WeatherProperties properties = new WeatherPropertiesBuilder().propertiesFromFile().build();
        ForecastRequestClient forecastRequest = new ForecastRequestClient(properties);

        Forecast forecast = forecastRequest.getForecast();

        JFrame frame = new JFrame("FormMain");
        frame.setContentPane(new FormMain(forecast).getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
