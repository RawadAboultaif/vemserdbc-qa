package br.com.dbccompany.service;

import br.com.dbccompany.dto.RelatorioDTO;
import br.com.dbccompany.utils.Login;

import static io.restassured.RestAssured.*;

public class PessoaService {
    String baseUrl = "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api";

//    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX1VTVUFSSU8iLCJST0xFX01BUktFVElORyIsIlJPTEVfQURNSU4iXSwiaWF0IjoxNjY3NDk3MzA2LCJleHAiOjE2Njc1ODM3MDZ9.Gjkc6hggglOI_K_0VgYrXb3Txg_Eo1a7IGTDNUsZwhs";
String tokenAdm = new Login().autenticacaoAdmin();
    public RelatorioDTO[] buscaRelatorio() {
        RelatorioDTO[] result =
        given()
                .log().all()
                .header("Authorization", tokenAdm)
        .when()
                .get(baseUrl + "/pessoa/relatorio")
        .then()
                .log().all()
                .statusCode(200)
                .extract().as(RelatorioDTO[].class)
        ;
        return result;
    }
}
