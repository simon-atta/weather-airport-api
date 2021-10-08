package com.crossover.trial.weather.resources.query;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

/**
 * The Weather App REST endpoint allows clients to query, update and check health stats. Currently, all data is
 * held in memory. The end point deploys to a single container
 *
 * @author code test administrator
 */
@Path("/query")
public class RestWeatherQueryEndpoint implements WeatherQueryEndpoint {

    public final static Logger LOGGER = Logger.getLogger("WeatherQuery");

	@Override
	public String ping() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response weather(String iata, String radiusString) {
		// TODO Auto-generated method stub
		return null;
	}

    

}
