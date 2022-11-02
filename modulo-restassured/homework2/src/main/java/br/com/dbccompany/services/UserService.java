package br.com.dbccompany.services;

import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.dto.UserPayloadDTO;

import com.google.gson.Gson;

import io.restassured.http.ContentType;

import java.io.IOException;
import java.util.*;

import static br.com.dbccompany.utils.Util.lerJson;
import static io.restassured.RestAssured.given;


public class UserService {

    String baseUrl = "https://petstore.swagger.io/v2";
    public ResponseDTO adicionarUserLista(Object jsonBody, String Method) {

        List<Object> deuCertoFinalmente = new ArrayList<>();
        deuCertoFinalmente.add(jsonBody);

        ResponseDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(deuCertoFinalmente)
                .when()
                        .post(baseUrl + "/user/"+Method)
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO adicionarUsuario(Object jsonBody) {

        ResponseDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(jsonBody)
                .when()
                        .post(baseUrl + "/user")
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public UserPayloadDTO consultarUsuario(String userName) {
        UserPayloadDTO result =
                given()
                        .log().all()
                        .pathParam("userName", userName)
                .when()
                        .get(baseUrl + "/user/{userName}")
                .then()
                        .log().all()
                        .extract().as(UserPayloadDTO.class)
                ;
        return result;
    }

    public ResponseDTO consultarUsuarioInexistente(String userName) {
        ResponseDTO result =
                given()
                        .log().all()
                        .pathParam("userName", userName)
                .when()
                        .get(baseUrl + "/user/{userName}")
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO atualizarUsuario(Object requestBody, String userName) {
        ResponseDTO result =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                .when()
                        .put(baseUrl + "/user/"+userName)
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO deletarUser(String userName) {

        ResponseDTO result =
                given()
                        .pathParam("userName", userName)
                .when()
                        .delete(baseUrl + "/user/{userName}")
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO loginUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/user1.json");
        Gson gson = new Gson();
        UserPayloadDTO objJson = gson.fromJson(jsonBody, UserPayloadDTO.class);
        ResponseDTO result =
                given()
                        .log().all()
                        .pathParam("username", objJson.getUsername())
                        .pathParam("password", objJson.getPassword())
                .when()
                        .get(baseUrl + "/user/login?username={username}&password={password}")
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }

    public ResponseDTO logoutUser() {
        ResponseDTO result =
                given()
                        .log().all()
                .when()
                        .get(baseUrl + "/user/logout")
                .then()
                        .log().all()
                        .extract().as(ResponseDTO.class)
                ;
        return result;
    }
}
