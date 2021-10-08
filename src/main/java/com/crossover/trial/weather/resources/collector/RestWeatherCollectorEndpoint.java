package com.crossover.trial.weather.resources.collector;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import com.crossover.trial.weather.model.Airport;
import com.crossover.trial.weather.services.AirportService;

/**
 * A REST implementation of the WeatherCollector API. Accessible only to airport
 * weather collection sites via secure VPN.
 *
 * @author code test administrator
 */

@Path("/collect")
@Controller
public class RestWeatherCollectorEndpoint implements WeatherCollectorEndpoint {
    private final static Logger LOGGER = LoggerFactory.getLogger(RestWeatherCollectorEndpoint.class);

    @Autowired
    private AirportService airportService;

    @Override
    public Response ping() {
        return Response.status(Response.Status.OK).entity("ready").build();
    }

    @Override
    public Response addAirport(String iata, String latString, String longString) {
        try {
            Assert.hasText(iata, "iata is empty!");
            Assert.hasText(latString, "latString is empty!");
            Assert.hasText(longString, "longString is empty!");

            if (airportService.getAirport(iata) != null) {
                LOGGER.debug("addAirport({}, {}, {}) already exists", iata, latString, longString);
                return Response.status(Response.Status.FORBIDDEN).build();
            }

            LOGGER.debug("addAirport({}, {}, {})", iata, latString, longString);
            airportService.addAirport(iata, latString, longString);
            return Response.status(Response.Status.OK).build();
        } catch (IllegalArgumentException exception) {
            LOGGER.error("Vaildation error", exception);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception exception) {
            LOGGER.error("Something went wrong", exception);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public Response getAirports() {
        try {
            LOGGER.debug("getAirports()");
            Set<String> retval = new HashSet<>();
            for (Airport ad : airportService.getAirports()) {
                retval.add(ad.getIata());
            }
            return Response.status(Response.Status.OK).entity(retval).build();

        } catch (Exception exception) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public Response getAirport(String iata) {
        try {
            Assert.hasText(iata, "iata is empty!");

            Airport airport = airportService.getAirport(iata);
            if (airport != null) {
                return Response.status(Response.Status.OK).entity(airport).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

        } catch (IllegalArgumentException exception) {
            LOGGER.error("Vaildation error", exception);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception exception) {
            LOGGER.error("Something went wrong", exception);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public Response updateWeather(String iataCode, String pointType, String datapointJson) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response deleteAirport(String iata) {
        try {
            Assert.hasText(iata, "iata is empty!");

            if (airportService.getAirport(iata) == null) {
                LOGGER.debug("deleteAirport({}) ", iata);
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                LOGGER.debug("deleteAirport({}) ", iata);
                airportService.deleteAirport(iata);
                return Response.status(Response.Status.OK).build();
            }

        } catch (IllegalArgumentException exception) {
            LOGGER.error("Vaildation error", exception);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception exception) {
            LOGGER.error("Something went wrong", exception);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @Override
    public Response exit() {
        System.exit(0);
        return Response.noContent().build();
    }

}
