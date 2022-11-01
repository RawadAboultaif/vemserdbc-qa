package br.pb.rawad.rest;

import io.restassured.http.ContentType;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredExemplo {
    private final String baseUrl= "https://reqres.in/api";

    @Test
    public void testeDeveConsultarpagina2() {
        given()
                .log().all()
                .queryParam("page", "2")
        .when()
                .get(baseUrl +"/users")
        .then()
                .log().all()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data", hasSize(6))
                .body("data.first_name", hasItem("Michael"))
                .body("data[1].id", is(8))
                ;
    }

    @Test
    public void testeDeveBusucarUsuario() {
        given()
                .log().all()
                .pathParam("id", 2)
        .when()
                .get(baseUrl + "/users/{id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("data.email", is("janet.weaver@reqres.in"))
        ;
    }

    @Test
    public void testeDeveRetornarStatus404() {
        given()
                .log().all()
                .pathParam("id", 23)
        .when()
                .get(baseUrl + "/users/{id}")
        .then()
                .log().all()
                .statusCode(404)
                ;
    }

    @Test
    public void testeDeveRetornarListaRecursos() {
        given()
                .log().all()
                .pathParam("unknown", "unknown")
        .when()
                .get(baseUrl + "/{unknown}")
        .then()
                .log().all()
                .statusCode(200)
                .body("data", not(nullValue()))
        ;
    }

    @Test
    public void testeDeveRetornarListaRecursosId() {
        given()
                .log().all()
                .pathParam("unknown", "unknown")
                .pathParam("id", 2)
        .when()
                .get(baseUrl + "/{unknown}/{id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("data.year", is(2001))
        ;
    }

    @Test
    public void testeNaoDeveRetornarListaRecursosId() {
        given()
                .log().all()
                .pathParam("unknown", "unknown")
                .pathParam("id", 23)
        .when()
                .get(baseUrl + "/{unknown}/{id}")
        .then()
                .log().all()
                .statusCode(404)
        ;
    }

    @Test
    public void testeDeveSalvarusuario() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"Rawad\", \"Job\": \"QA\"}")
        .when()
                .post(baseUrl + "/users")
        .then()
                .log().all()
                .statusCode(201)
                .body("name", is("Rawad"))
                .body("Job", is("QA"))
                .body("id", not(nullValue()))
                .body(containsString("createdAt"))
        ;
    }

    @Test
    public void testeDeveAtualizaUsuario(){
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"Rawad\", \"Job\": \"QA\"}")
                .pathParam("id", 2)
        .when()
                .put(baseUrl + "/users/{id}")
        .then()
                .statusCode(200)
                .body("name", is("Rawad"))
                .body(containsString("updatedAt"))
        ;
    }

    @Test
    public void testeDeveAtualizarUsuarioPatch() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"Rawad\", \"Job\": \"Dev-Front\"}")
                .pathParam("id", 2)
        .when()
                .patch(baseUrl + "/users/{id}")
        .then()
                .statusCode(200)
                .body("Job", is("Dev-Front"))
        ;
    }

    @Test
    public void testeDeveDeletarUsuario(){
        given()
                .log().all()
                .pathParam("id", 2)
        .when()
                .delete(baseUrl + "/users/{id}")
        .then()
                .statusCode((204))
        ;
    }

    @Test
    public void testeDeveRegistrarNovoUsuario() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}")
        .when()
                .post(baseUrl + "/register")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"))
        ;
    }

    @Test
    public void testeDeveNaoRegistrarNovoUsuarioFaltandoArroba() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"eve.hol\", \"password\": \"pistol\"}")
        .when()
                .post(baseUrl + "/register")
        .then()
                .log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void testeDeveLogarUsusario() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
        .when()
                .post(baseUrl + "/login")
        .then()
                .log().all()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"))
        ;
    }

    @Test
    public void testeDeveNaoLogarUsusario() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"peter@klaven\"}")
        .when()
                .post(baseUrl + "/login")
        .then()
                .log().all()
                .statusCode(400)
                .body("error", is("Missing password"))
        ;
    }

    @Test
    public void testeDeveRetornarMesmoComDelay() {
        given()
                .log().all()
                .pathParam("delay", "?delay=3")
        .when()
                .get(baseUrl + "/users{delay}")
        .then()
                .log().all()
                .statusCode(200)
                .body("data", notNullValue())
        ;
    }
}
