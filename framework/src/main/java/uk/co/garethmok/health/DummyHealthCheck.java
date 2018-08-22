package uk.co.garethmok.health;

import com.codahale.metrics.health.HealthCheck;

public class DummyHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy("This is a dummy health check. Please implement this for real.");
    }
}
