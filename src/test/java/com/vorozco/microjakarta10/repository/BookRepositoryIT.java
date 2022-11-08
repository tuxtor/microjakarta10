package com.vorozco.microjakarta10.repository;

import com.vorozco.microjakarta10.model.Book;
import jakarta.inject.Inject;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ArquillianExtension.class)
class BookRepositoryIT {

    @Test
    @RunAsClient
    void create() {

        String book = """
                {
                    "title": "Java EE 8",
                    "description": "Java EE 8",
                    "isbn": "123456789"
                }
                """;

        //Rest assured post book
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books")
                .then()
                .statusCode(200);
    }
}
