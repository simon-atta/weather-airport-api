package com.crossover.trial.weather.repo;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.crossover.trial.weather.model.AtmosphericInformation;
import com.crossover.trial.weather.resources.collector.RestWeatherCollectorEndpoint;

/**
 * Weather repository handle all operations for atmospheric information for each
 * airport. {@link WeatherRepo}
 */
@Component
public class WeatherRepoImpl implements WeatherRepo {

	private final static Logger LOGGER = LoggerFactory.getLogger(RestWeatherCollectorEndpoint.class);

	private final ConcurrentHashMap<String, AtmosphericInformation> airportsList = new ConcurrentHashMap<>();

	@Override
	public void addAirportAtmosphericInformation(String iata, AtmosphericInformation atmosphericInformation) {
		LOGGER.debug("WeatherRepoImpl - addAirportAtmosphericInformation({})", iata);
		airportsList.put(iata, atmosphericInformation);
	}

    @Override
    public AtmosphericInformation getAtmosphericInformationByIata(String iata) {
        LOGGER.debug("WeatherRepoImpl - getAtmosphericInformationByIata({})", iata);
        return airportsList.get(iata);
    }

    @Override
    public void UpdateAtmosphericInformation(String iata, AtmosphericInformation atmosphericInformation) {
        LOGGER.debug("WeatherRepoImpl - UpdateAtmosphericInformation({})", iata);
        airportsList.put(iata, atmosphericInformation);
    }

}
