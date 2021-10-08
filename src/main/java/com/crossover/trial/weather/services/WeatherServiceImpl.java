package com.crossover.trial.weather.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.trial.weather.exception.WeatherException;
import com.crossover.trial.weather.model.AtmosphericInformation;
import com.crossover.trial.weather.model.DataPoint;
import com.crossover.trial.weather.model.DataPointType;
import com.crossover.trial.weather.repo.WeatherRepo;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final static Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Autowired
    private WeatherRepo weatherRepo;

    @Override
    public void updateWeather(String iataCode, String pointType, String datapointJson) {

        AtmosphericInformation atmosphericInformation = weatherRepo.getAtmosphericInformationByIata(iataCode);

    }

    /**
     * update atmospheric information with the given data point for the given
     * point type
     *
     * @param atmosphericInformation
     *        the atmospheric information object to update
     * @param pointType
     *        the data point type as a string
     * @param dataPoint
     *        the actual data point
     */
    public void updateAtmosphericInformation(AtmosphericInformation atmosphericInformation, String pointType, DataPoint dataPoint) throws WeatherException {


        if (pointType.equalsIgnoreCase(DataPointType.WIND.name())) {
            if (dataPoint.getMean() >= 0) {
                atmosphericInformation.setWind(dataPoint);
                atmosphericInformation.setLastUpdateTime(System.currentTimeMillis());
                return;
            }
        }

        if (pointType.equalsIgnoreCase(DataPointType.TEMPERATURE.name())) {
            if (dataPoint.getMean() >= -50 && dataPoint.getMean() < 100) {
                atmosphericInformation.setTemperature(dataPoint);
                atmosphericInformation.setLastUpdateTime(System.currentTimeMillis());
                return;
            }
        }

        if (pointType.equalsIgnoreCase(DataPointType.HUMIDTY.name())) {
            if (dataPoint.getMean() >= 0 && dataPoint.getMean() < 100) {
                atmosphericInformation.setHumidity(dataPoint);
                atmosphericInformation.setLastUpdateTime(System.currentTimeMillis());
                return;
            }
        }

        if (pointType.equalsIgnoreCase(DataPointType.PRESSURE.name())) {
            if (dataPoint.getMean() >= 650 && dataPoint.getMean() < 800) {
                atmosphericInformation.setPressure(dataPoint);
                atmosphericInformation.setLastUpdateTime(System.currentTimeMillis());
                return;
            }
        }

        if (pointType.equalsIgnoreCase(DataPointType.CLOUDCOVER.name())) {
            if (dataPoint.getMean() >= 0 && dataPoint.getMean() < 100) {
                atmosphericInformation.setCloudCover(dataPoint);
                atmosphericInformation.setLastUpdateTime(System.currentTimeMillis());
                return;
            }
        }

        if (pointType.equalsIgnoreCase(DataPointType.PRECIPITATION.name())) {
            if (dataPoint.getMean() >= 0 && dataPoint.getMean() < 100) {
                atmosphericInformation.setPrecipitation(dataPoint);
                atmosphericInformation.setLastUpdateTime(System.currentTimeMillis());
                return;
            }
        }

        throw new IllegalStateException("couldn't update atmospheric data");
    }

}
