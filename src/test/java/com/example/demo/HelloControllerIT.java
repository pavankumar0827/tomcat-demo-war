package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {


@LocalServerPort
int port;


@Autowired
TestRestTemplate restTemplate;


@Test
public void helloEndpointWorks() {
String body = this.restTemplate.getForObject("http://localhost:" + port + "/hello", String.class);
assertThat(body).isEqualTo("Hello from Tomcat Demo");
}
}
