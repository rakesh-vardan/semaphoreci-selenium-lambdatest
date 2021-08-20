package org.lambdatest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    @Test
    public void testAPI() {
        given().when().get("https://jsonplaceholder.typicode.com/users").then().statusCode(200);
    }

}
