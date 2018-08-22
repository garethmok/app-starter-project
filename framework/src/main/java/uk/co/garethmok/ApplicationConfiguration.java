package uk.co.garethmok;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class ApplicationConfiguration extends Configuration {

    private String appName;

    @JsonProperty
    public String appName() {
        return appName;
    }

}
