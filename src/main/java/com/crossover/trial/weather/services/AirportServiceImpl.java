package com.crossover.trial.weather.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.trial.weather.model.Airport;
import com.crossover.trial.weather.model.AtmosphericInformation;
import com.crossover.trial.weather.repo.AirportRepo;
import com.crossover.trial.weather.repo.WeatherRepo;

@Service
public class AirportServiceImpl implements AirportService {

    private final static Logger LOGGER = LoggerFactory.getLogger(AirportServiceImpl.class);

    @Autowired
    private AirportRepo airportRepo;

    @Autowired
    private WeatherRepo weatherRepo;

    @Override
    public void init() {
        airportRepo.init();
    }

    @Override
    public void addAirport(String iata, String latString, String longString) {
        LOGGER.debug("AirportServiceImpl - addAirport({}, {}, {})", iata, latString, longString);
        airportRepo.addAirport(new Airport(iata, Double.valueOf(latString), Double.valueOf(longString)));
        weatherRepo.addAirportAtmosphericInformation(iata, new AtmosphericInformation());
    }

    @Override
    public List<Airport> getAirports() {
        LOGGER.debug("AirportServiceImpl - getAirports()");
        return airportRepo.getAirports();
    }

    @Override
    public Airport getAirport(String iata) {
        LOGGER.debug("AirportServiceImpl - getAirport({})", iata);
        return airportRepo.getAirport(iata);
    }

    @Override
    public void deleteAirport(String iata) {
        LOGGER.debug("AirportServiceImpl - deleteAirport({})", iata);
        airportRepo.deleteAirport(iata);
    }

}
