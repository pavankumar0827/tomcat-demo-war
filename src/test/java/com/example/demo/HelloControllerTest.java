package com.example.demo;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class HelloControllerTest {


@Test
void testHello() {
HelloController c = new HelloController();
assertEquals("Hello from Tomcat Demo", c.hello());
}
}
