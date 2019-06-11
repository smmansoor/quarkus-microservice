package com.codewithmansoor;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        RestAssured.given()
          .when().get("/api/greet")
          .then()
             .statusCode(200)
             .body(CoreMatchers.containsString("hello"));
    }

}