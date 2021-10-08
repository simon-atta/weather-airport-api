package com.crossover.trial.weather.repo;

import com.crossover.trial.weather.model.AtmosphericInformation;

/**
 * The interface shared to weather service.
 *
 * @author Simon Atta.
 */
public interface WeatherRepo {

    /**
     * Adding new airport atmospheric information.
     *
     * @param iata
     *        String
     * @param atmosphericInformation
     *        AtmosphericInformation
     */
    void addAirportAtmosphericInformation(String iata, AtmosphericInformation atmosphericInformation);

    /**
     * Get atmospheric information by IATA.
     *
     * @param iata
     *        String
     * @return AtmosphericInformation
     */
    AtmosphericInformation getAtmosphericInformationByIata(String iata);

    /**
     * Update atmospheric information by IATA.
     *
     * @param iata
     *        String
     * @param atmosphericInformation
     *        AtmosphericInformation
     */
    void UpdateAtmosphericInformation(String iata, AtmosphericInformation atmosphericInformation);

}
