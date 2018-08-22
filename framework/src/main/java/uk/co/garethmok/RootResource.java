package uk.co.garethmok;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RootResource {

    private String appName;

    public RootResource(final String appName) {
        this.appName = appName;
    }

    @GET
    public Response hello() {
        return Response.ok("Hello, this is " + appName).build();
    }

}
