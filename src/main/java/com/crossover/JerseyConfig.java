package com.crossover;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author Simon Atta.
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {

        packages("com.crossover.trial.weather");

    }
}
