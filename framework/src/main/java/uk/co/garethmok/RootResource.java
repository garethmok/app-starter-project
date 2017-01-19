package uk.co.garethmok;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Path("/")
public class RootResource {

    public RootResource() {
    }

    @GET
    public Response hello() throws ExecutionException, InterruptedException, IOException {
        return Response.ok("hello world").build();
    }

}
