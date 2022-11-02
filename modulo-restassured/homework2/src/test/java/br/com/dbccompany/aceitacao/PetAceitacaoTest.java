package br.com.dbccompany.aceitacao;

import br.com.dbccompany.dto.PetPayloadDTO;
import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.services.PetService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Integer.parseInt;

public class PetAceitacaoTest {
    String jsonBody = lerJson("src/test/resources/data/pet1.json");
    PetService service = new PetService();

    public PetAceitacaoTest() throws IOException {
    }

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void testeDeveAdicionarPet() {



        PetPayloadDTO resultService = service.adicionarPet(jsonBody);

        Assert.assertEquals(resultService.getId(), "20221101");
        Assert.assertEquals(resultService.getName(), "Scooby");

        service.deletarPet(parseInt(resultService.getId()));
    }

    @Test
    public void testeDeveConsultarPetPorId() throws IOException {

        service.adicionarPet(jsonBody);
        Integer idPet = 20221101;

        PetPayloadDTO resultService = service.consultarPetPorId((idPet));

        Assert.assertEquals(resultService.getId(), "20221101");
        Assert.assertEquals(resultService.getName(), "Scooby");

        service.deletarPet(parseInt(resultService.getId()));
    }

    @Test
    public void testeDeveAtualizarPetPut() throws IOException {

        service.adicionarPet(jsonBody);

        PetPayloadDTO resultService = service.atualizarPetPut(jsonBody);

        Assert.assertEquals(resultService.getId(), "20221101");
        Assert.assertEquals(resultService.getName(), "Scooby-Doo");

        service.deletarPet(parseInt(resultService.getId()));
    }

    @Test
    public void testeDeveDeletarPet() {

        service.adicionarPet(jsonBody);
        Integer idPet = 20221101;

        ResponseDTO responseService = service.deletarPet(idPet);

        Assert.assertEquals(responseService.getCode(), "200");

    }
}


