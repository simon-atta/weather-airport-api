# Java Project - Weather

## Project Background

The Airport Weather Service (AWS) is a REST application for collecting and redistributing meteorological data for a
handful of airports. The service provides two distinct interfaces. One is a query interface, used by dozens of client
systems to retrieve information such mean temperature and max wind speed. The other is a collector interface used by
airports to update meteorological data stored in AWS. You'll find more detail about these interfaces in
WeatherCollectorEndpoint.java and WeatherQueryEndpoint.java. To see the service in action, you can run the
included run-ws.sh which launches the server and demonstrates a simple client hitting the REST endpoint.

Over time, the number of airports and clients of the service has grown. Today, the application finds itself filling a
role much larger than it was initially designed for - resulting in poor reliability and slow performance. Your task is
to apply best practices to the code and fix design defects, while keeping in mind that since this is a live application,
you must be careful not to change external interfaces.

### REST API

The application currently supports the following REST APIs, you should not change the parameters or response format, but may change the implementation.
* GET /collect/ping
* POST /collect/weather/{iata}/{pointType}
* GET /query/ping
* GET /query/weather/{iata}/{radius}

Unimplemented REST APIs
* POST /collect/airport/{iata}/{lat}/{long}
* DELETE /collect/airport/{iata}

### Add a new feature
Now that the code is cleaned up, it's time to add a feature. The feature to implement, which you may have noticed in
your code review, is that airports are hard coded. You should implement the ```[POST|DELETE] /collect/airport```
endpoints. You should also create an ```AirportLoader``` which will read airports.dat and call your endpoint.
The application will need to support at least 1000 unique airports.

A sample airports.dat is included with the trial, but a more complete airport.dat will be used to evaluate your work.
The airports.dat is a comma separated file with the following headers:

Header   	| Description
------------|------------
City		| Main city served by airport. May be spelled differently from name.
Country		| Country or territory where airport is located.
IATA/FAA 	| 3-letter FAA code or IATA code (blank or "" if not assigned)
ICAO		| 4-letter ICAO code (blank or "" if not assigned)
Latitude 	| Decimal degrees, up to 6 significant digits. Negative is South, positive is North.
Longitude	| Decimal degrees, up to 6 significant digits. Negative is West, positive is East.
Altitude	| In feet
Timezone	| Hours offset from UTC. Fractional hours are expressed as decimals. (e.g. India is 5.5)
DST			| One of E (Europe), A (US/Canada), S (South America), O (Australia), Z (New Zealand), N (None) or U (Unknown) 


