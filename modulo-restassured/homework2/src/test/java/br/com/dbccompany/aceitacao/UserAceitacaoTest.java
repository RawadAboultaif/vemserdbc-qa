package br.com.dbccompany.aceitacao;

import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.dto.UserPayloadDTO;
import br.com.dbccompany.services.UserService;
import br.com.dbccompany.utils.Util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class UserAceitacaoTest {

    public UserAceitacaoTest() {

    }
    UserService service = new UserService();


    // ******* Testando Metodos POST ************ //
    @Test
    public void testeDeveAdicionarUsuarioArray() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();

        ResponseDTO resultService = service.adicionarUserLista(novoUsuario, "createWithArray");

        Assert.assertEquals(resultService.getCode(), "200");

        service.deletarUser(novoUsuario.getUsername());
    }

    @Test
    public void testeDeveAdicionarUsuarioList() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();

        ResponseDTO resultService = service.adicionarUserLista(novoUsuario, "createWithList");

        Assert.assertEquals(resultService.getCode(), "200");

        service.deletarUser(novoUsuario.getUsername());
    }

    @Test
    public void testeDeveAdicionarUsuarioLogado() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();
        service.adicionarUserLista(novoUsuario, "createWithList");
        service.loginUser();

        ResponseDTO resultService = service.adicionarUsuario(novoUsuario);
        Assert.assertEquals(resultService.getCode(), "200");

        service.deletarUser(novoUsuario.getUsername());
    }

    @Test
    public void testeNaoDeveAdicionarUsuarioQueNaoEstaLogado() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();

        ResponseDTO resultService = service.adicionarUsuario(novoUsuario);
        Assert.assertEquals(resultService.getCode(), "500");

        service.deletarUser(novoUsuario.getUsername());
    }


    // ******* Testando Metodos GET ************ //


    @Test
    public void testeDeveBuscarUserName() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();
        service.adicionarUsuario(novoUsuario);

        UserPayloadDTO resultService = service.consultarUsuario(novoUsuario.getUsername());

        Assert.assertEquals(resultService.getEmail(), novoUsuario.getEmail());

        service.deletarUser(novoUsuario.getUsername());
    }

    @Test
    public void testeDeveRetornarErroAoBuscarPorUsernameInexistente() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();

        ResponseDTO resultService = service.consultarUsuarioInexistente(novoUsuario.getUsername());

        Assert.assertEquals(resultService.getMessage(), "User not found");

    }

    @Test
    public void testeDeveLogarUsuario() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();
        service.adicionarUserLista(novoUsuario, "createWithList");
        ResponseDTO resultService = service.loginUser();

        Assert.assertEquals(resultService.getCode(), "200");

        service.deletarUser(novoUsuario.getUsername());
    }

    @Test
    public void testeDeveDeslogarUsusario() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();
        service.adicionarUserLista(novoUsuario, "createWithList");
        service.loginUser();
        ResponseDTO resultService = service.logoutUser();

        Assert.assertEquals(resultService.getCode(), "200");

        service.deletarUser(novoUsuario.getUsername());
    }


    // ******* Testando Metodos PUT ************ //

    @Test
    public void testeDeveAtualizarUsuario() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();
        service.adicionarUserLista(novoUsuario, "createWithList");
        service.loginUser();
        novoUsuario.setPassword("teste");

        ResponseDTO resultService = service.atualizarUsuario(novoUsuario, novoUsuario.getUsername());
        UserPayloadDTO resultSearch = service.consultarUsuario(novoUsuario.getUsername());

        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultSearch.getPassword(), "teste");

        service.deletarUser(novoUsuario.getUsername());
    }

    @Test
    public void testeNaoDeveAtualizarUsuarioPorFaltaDeLogin() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();
        service.adicionarUserLista(novoUsuario, "createWithList");
        service.logoutUser();
        novoUsuario.setPassword("teste");

        ResponseDTO resultService = service.atualizarUsuario(novoUsuario, novoUsuario.getUsername());

        Assert.assertEquals(resultService.getCode(), "401");

        service.deletarUser(novoUsuario.getUsername());
    }

    // ******* Testando Metodos DELETE ************ //

    @Test
    public void testeDeveDeletarUsuario() throws IOException {
        UserPayloadDTO novoUsuario = Util.novoUser();
        service.adicionarUserLista(novoUsuario, "createWithList");

        ResponseDTO resultService = service.deletarUser(novoUsuario.getUsername());
        ResponseDTO resultSearch = service.consultarUsuarioInexistente(novoUsuario.getUsername());

        Assert.assertEquals(resultSearch.getMessage(), "User not found");
        Assert.assertEquals(resultService.getCode(), "200");
    }
}
