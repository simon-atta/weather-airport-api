package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.crossover.trial.weather.services.AirportService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.*" })
public class WeatherAirportApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WeatherAirportApplication.class, args);
        context.getBean(AirportService.class).init();
    }

}
