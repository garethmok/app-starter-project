package uk.co.garethmok;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {

    private static final String CONFIG_KEY = "jersey.config.server.provider.classnames";

    private static ServletHolder servlet;

    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server server = new Server(8080);
        server.setHandler(context);

        configureServlet(context);
        register(RootResource.class);

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }

    private static void configureServlet(ServletContextHandler context) {
        servlet = context.addServlet(ServletContainer.class, "/*");
        servlet.setInitOrder(0);
    }

    private static void register(Class resourceClass) {
        servlet.setInitParameter(CONFIG_KEY, resourceClass.getCanonicalName());
    }
}
