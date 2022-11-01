package br.pb.rawad.rest;

import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredTest {
    @Test
    public void structuralDoTest() {

    }

    @Test
    public void testDevConsulterUsuriousComId2() {
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", Matchers.is(2));
    }

}