package uk.co.garethmok.health;

import com.codahale.metrics.health.HealthCheck;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DummyHealthCheckTest {

    @Test
    public void healthy() throws Exception {
        final DummyHealthCheck testSubject = new DummyHealthCheck();

        final HealthCheck.Result result = testSubject.check();

        assertThat(result.isHealthy()).isTrue();
        assertThat(result.getMessage()).isEqualTo("This is a dummy health check. Please implement this for real.");
    }

}