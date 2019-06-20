package uk.co.garethmok.billmanager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.ok;

@Path("/bill-manager")
@Produces(MediaType.APPLICATION_JSON)
public class BillManagerController {

    private BillManagerService billManagerService;

    public BillManagerController(BillManagerService billManagerService) {
        this.billManagerService = billManagerService;
    }

    @Path("/thing")
    @GET
    public Response thing() {
        String whatever = this.billManagerService.whatever();
        return ok(whatever).build();
    }
}
