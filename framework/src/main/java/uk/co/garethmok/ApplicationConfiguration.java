package uk.co.garethmok;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

class ApplicationConfiguration extends Configuration {

    private String appName;

    @JsonProperty
    String appName() {
        return appName;
    }

}
