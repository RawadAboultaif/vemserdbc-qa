package br.com.dbccompany.utils;

import br.com.dbccompany.dto.UserPayloadDTO;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {
    public static String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    public static UserPayloadDTO novoUser() throws IOException {

        JsonManipulation.criarJsonUsuario();
        String jsonBody = lerJson("src/test/resources/data/user1.json");
        Gson gson = new Gson();
        UserPayloadDTO objJson = gson.fromJson(jsonBody, UserPayloadDTO.class);

        return objJson;
    }
}
