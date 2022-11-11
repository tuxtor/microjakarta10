package com.vorozco.microjakarta10.resources;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ArquillianExtension.class)
class RestResourceIT {


    @Test
    @RunAsClient
    public void testURL() throws Exception {
        //Rest Assured get hello
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(containsString("Hola desde Jakarta EE 10 y CI/CD"));
    }
}
