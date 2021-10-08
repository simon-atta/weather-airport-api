package com.crossover.trial.weather.services;

/**
 * Weather service handle all logic for weather updates and update data points.
 *
 * @author Simon Atta.
 */
public interface WeatherService {

    /**
     * Update data point weather.
     *
     * @param iataCode
     *        String
     * @param pointType
     *        String
     * @param datapointJson
     *        String
     */
    void updateWeather(String iataCode, String pointType, String datapointJson);
}
