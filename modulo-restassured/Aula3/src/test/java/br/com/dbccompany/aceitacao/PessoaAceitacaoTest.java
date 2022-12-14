package br.com.dbccompany.aceitacao;

import br.com.dbccompany.dto.RelatorioDTO;
import br.com.dbccompany.service.PessoaService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PessoaAceitacaoTest {

    PessoaService service = new PessoaService();

    @Test
    public void deveRetonarRelatorioPessoas() {

        RelatorioDTO[] resultService = service.buscaRelatorio();

        Assert.assertEquals(resultService[0].getNomePessoa().toUpperCase(), "Maicon Machado Gerardi".toUpperCase());
    }
}
