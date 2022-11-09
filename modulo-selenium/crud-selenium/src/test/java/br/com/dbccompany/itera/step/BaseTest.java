package br.com.dbccompany.itera.step;

import br.com.dbccompany.itera.util.Browser;
import org.junit.After;
import org.junit.Before;

public class BaseTest extends Browser {

    @Before
    public void abrirNavegador() {
        browserUp("https://itera-qa.azurewebsites.net");
    }

    @After
    public void fecharNavegador() {
        browserDown();
    }
}