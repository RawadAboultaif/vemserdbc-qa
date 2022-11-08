package br.com.dbccompany.utils;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class MassaDeDados {

    public static HashMap<String, Object> criarUsuario() {
        Faker faker = new Faker();

        HashMap<String, Object> params = new HashMap<>();


        params.put("id", faker.idNumber().hashCode());
        params.put("username", faker.name().firstName());
        params.put("firstName", faker.name().firstName());
        params.put("lastName", faker.name().lastName());
        params.put("email", faker.internet().emailAddress());
        params.put("password", faker.internet().password());
        params.put("phone", faker.number().numberBetween(9000000, 9999999));
        params.put("userStatus", "0");

        return params;
    }
}
