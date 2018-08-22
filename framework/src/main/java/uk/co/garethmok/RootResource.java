package uk.co.garethmok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RootResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootResource.class);

    private String appName;

    RootResource(final String appName) {
        this.appName = appName;
    }

    @GET
    public Response hello() {
        LOGGER.info("RootResource received a request.");
        
        return Response.ok("Hello, this is " + appName).build();
    }

}
