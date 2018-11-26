package uk.co.garethmok;

import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class RootResourceTest {

    @Test
    public void saysHello() {
        final RootResource testSubject = new RootResource("turnip");
        final Response response = testSubject.hello();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getEntity()).isEqualTo("Hello, this is turnip");
    }

}