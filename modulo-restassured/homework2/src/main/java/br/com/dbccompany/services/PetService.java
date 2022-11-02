package br.com.dbccompany.services;

import br.com.dbccompany.dto.PetPayloadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PetService {

    String baseUrl = "https://petstore.swagger.io/v2";

    public PetPayloadDTO adicionarPet(String requestBody) {
        PetPayloadDTO result =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
        .when()
                .post(baseUrl + "/pet")
        .then()
                .log().all()
                .extract().as(PetPayloadDTO.class)
        ;

        return result;
    }

    public PetPayloadDTO consultarPetPorId(Integer idPet) {
        PetPayloadDTO result =
        given()
                .log().all()
                .pathParam("idPet", idPet)
        .when()
                .get(baseUrl + "/pet/{idPet}")
        .then()
                .extract().as(PetPayloadDTO.class)
        ;

        return result;
    }

    public PetPayloadDTO atualizarPetPut(String requestBody) {
        PetPayloadDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                .when()
                        .post(baseUrl + "/pet")
                .then()
                        .log().all()
                        .extract().as(PetPayloadDTO.class)
                ;

        return result;
    }

    public ResponseDTO deletarPet(Integer idPet) {

        ResponseDTO result =
                given()
                        .pathParam("idPet", idPet)
                .when()
                        .delete(baseUrl + "/pet/{idPet}")
                .then()
                    .log().all()
                    .extract().as(ResponseDTO.class)
                ;
        return result;
    }
}
