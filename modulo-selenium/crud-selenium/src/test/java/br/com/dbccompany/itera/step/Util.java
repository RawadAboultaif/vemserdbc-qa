package br.com.dbccompany.itera.step;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Util extends BaseTest {


    public static void login() {
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.id("Username")).sendKeys("teste123");
        driver.findElement(By.id("Password")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
    }

    public static boolean compararCelulasDaTabela(String stringBuscada) {
        List<WebElement> teste = driver.findElements(By.tagName("td"));

        Boolean comparacao = false;

        for(int i = 0; teste.size() > i; i++) {
            if(teste.get(i).getText().equalsIgnoreCase(stringBuscada)) {
                comparacao = true;
            }
        }

        return comparacao;
    }
}
