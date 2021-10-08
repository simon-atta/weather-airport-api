package com.crossover.trial.weather.repo;

import java.util.List;

import com.crossover.trial.weather.model.Airport;

/**
 * The interface shared to airport service.
 *
 * @author Simon Atta.
 */
public interface AirportRepo {

    /**
     * This method handle initialize data for airports.
     */
    void init();

    /**
     * Add new airport into airport collection.
     *
     * @param airport
     *        Airport
     */
    void addAirport(Airport airport);

    /**
     * Get all aiports from collection and return it as list.
     *
     * @return List<Airport>
     */
    List<Airport> getAirports();

    /**
     * Get airport by iata.
     *
     * @param iata
     *        String
     * @return airport.
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
