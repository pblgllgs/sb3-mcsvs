package com.pblgllgs.productservice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();
    }

    @Test
    void shouldCreatedProduct() {
        String requestBody =
                """
                        		{
                        		    "name": "Shoes",
                        		    "description": "Aspernatur dicta vel laboriosam accusamus adipisci veniam ea natus.",
                        		    "price": 95.46
                        		}
                        """;
        RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(requestBody)
                .when()
                .post("/api/product")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("Shoes"))
                .body("description", Matchers.equalTo("Aspernatur dicta vel laboriosam accusamus adipisci veniam ea natus."))
                .body("price", Matchers.equalTo(Float.parseFloat("95.46")));
    }

}
