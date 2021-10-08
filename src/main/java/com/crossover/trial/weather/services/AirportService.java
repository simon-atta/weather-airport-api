package com.crossover.trial.weather.services;

import java.util.List;

import com.crossover.trial.weather.model.Airport;

/**
 * The interface has all business logic for airport.
 *
 * @author Simon Atta.
 */
public interface AirportService {

    /**
     * initialize data for airport at application startup.
     */
    void init();

    /**
     * Add new airport into airport repo also add new atmospheric information
     * into weather repo.
     *
     * @param iata
     *        String
     * @param latString
     *        String
     * @param longString
     *        String
     */
    void addAirport(String iata, String latString, String longString);

    /**
     * Get all airports.
     *
     * @return List<Airport>
     */
    List<Airport> getAirports();

    /**
     * Get airports by iata.
     *
     * @param iata
     *        String
     * @return Airport
     */
    Airport getAirport(String iata);

    /**
     * Delete airport by iata.
     *
     * @param iata
     *        String
     */
    void deleteAirport(String iata);

}
