package com.crossover.trial.weather.repo;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.crossover.trial.weather.model.Airport;

/**
 * Implementation of airport repo {@link AirportRepo}
 *
 * @author Simon Atta.
 */
@Component
public class AirportRepoImpl implements AirportRepo {

    private final static Logger LOGGER = LoggerFactory.getLogger(AirportRepoImpl.class);

    private final ConcurrentHashMap<String, Airport> airportsList = new ConcurrentHashMap<>();

    @Override
    public void init() {
        LOGGER.info("AirportRepoImpl : init()");
        addAirport(new Airport("BOS", -71.005181, 42.364347));
        addAirport(new Airport("EWR", -74.168667, 40.6925));
        addAirport(new Airport("JFK", -73.778925, 40.639751));
        addAirport(new Airport("LGA", -73.872608, 40.777245));
        addAirport(new Airport("MMU", -74.4148747, 40.79935));
    }

    @Override
    public void addAirport(Airport airport) {
        LOGGER.debug("AirportRepoImpl - addAirport({})", airport.getIata());
        airportsList.put(airport.getIata(), airport);
    }

    @Override
    public List<Airport> getAirports() {
        LOGGER.debug("AirportRepoImpl - getAirports()");
        return airportsList.values().stream().collect(Collectors.toList());
    }

    @Override
    public Airport getAirport(String iata) {
        LOGGER.debug("AirportRepoImpl - getAirport({})", iata);
        return airportsList.get(iata);
    }

    @Override
    public void deleteAirport(String iata) {
        LOGGER.debug("AirportRepoImpl - deleteAirport({})", iata);
        airportsList.remove(iata);
    }

}
