package com.vorozco.microjakarta10.repository;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;

@ExtendWith(ArquillianExtension.class)
public class OrderRepositoryIT {

    @Test
    @RunAsClient
    public void create(){

        String order = """
                {
                    "orderNo": 1,
                    "awbNumber": "1548964",
                    "orderState": "pending"
                }
                """;

        //Rest assured post book
        given()
                .contentType("application/json")
                .body(order)
                .when().post("/order")
                .then()
                .statusCode(200);
    }
}
