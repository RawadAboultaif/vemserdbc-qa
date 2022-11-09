package br.com.dbccompany.automationtesting.step;

import br.com.dbccompany.automationtesting.util.Browser;

import org.junit.After;
import org.junit.Before;

public class BaseTest extends Browser {

    @Before
    public void abrirNavegador() {
        browserUp("https://practice.automationtesting.in/my-account/");
    }

    @After
    public void fecharNavegador() {
        browserDown();
    }
}