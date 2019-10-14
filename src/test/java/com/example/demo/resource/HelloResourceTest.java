package com.example.demo.resource;

import com.example.demo.DemoApplication;
import com.example.demo.integration.HelloIntegration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloResourceTest {

    @LocalServerPort
    private int port;


    @Autowired
    Client client;

    @MockBean
    HelloIntegration helloIntegration;

    @Before
    public void setUp() {
        when(helloIntegration.hello()).thenReturn("tiger");
    }

    @Test
    public void hello() throws Exception {
        Response response = client.target("http://localhost:" + port + "/hello").request().get();
        String s = response.readEntity(String.class);
        assertEquals("tiger", s);
        verify(helloIntegration).hello();
    }
}