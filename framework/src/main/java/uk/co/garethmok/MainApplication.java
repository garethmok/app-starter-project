package uk.co.garethmok;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import uk.co.garethmok.health.DummyHealthCheck;

public class MainApplication extends Application<ApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MainApplication().run(args);
    }

    @Override
    public String getName() {
        return "test-thingy";
    }

    @Override
    public void initialize(final Bootstrap<ApplicationConfiguration> bootstrap) {
    }

    @Override
    public void run(final ApplicationConfiguration configuration,
                    final Environment environment) {
        environment.healthChecks().register("Dummy Health Check", new DummyHealthCheck());

        environment.jersey().register(new RootResource(configuration.appName()));
    }

}
