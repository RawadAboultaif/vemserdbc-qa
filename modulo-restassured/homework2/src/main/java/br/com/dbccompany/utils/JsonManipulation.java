package br.com.dbccompany.utils;

import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.HashMap;

public class JsonManipulation {
    public static void criarJsonUsuario() {
        String pathJson = "src/test/resources/data/user1.json";

        HashMap<String, Object> usuario = MassaDeDados.criarUsuario();


        try(PrintWriter out = new PrintWriter(new FileWriter(pathJson))) {
            out.write(usuario.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
