package uk.co.garethmok;

import org.junit.Test;

import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

public class RootResourceTest {
    @Test
    public void returnsOk() throws InterruptedException, ExecutionException, IOException {
        Response response = new RootResource().hello();
        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    }

    @Test
    public void returnsHello() throws InterruptedException, ExecutionException, IOException {
        Response response = new RootResource().hello();
        assertThat(response.getEntity()).isEqualTo("hello world");
    }

}
