package br.com.dbccompany.itera.step.tests;

import br.com.dbccompany.itera.step.Util;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;


public class testCrud extends Util{


    Faker faker = new Faker(Locale.of("pt_PT"));

    @Before
    public void loginPage(){
        Util.login();
    }

    @Test
    public void testBotaoBuscar() {

    }

    @Test
    public void testeCriarUsuario() {

        driver.findElement(By.cssSelector("body > div > div > p:nth-child(4) > a")).click();
        String email= faker.internet().emailAddress();
        driver.findElement(By.id("Name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("Company")).sendKeys(faker.company().name());
        driver.findElement(By.id("Address")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.id("City")).sendKeys(faker.address().city());
        driver.findElement(By.id("Phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.cssSelector("[value=\"Create\"]")).click();

        driver.findElement(By.id("searching")).sendKeys(email);
        driver.findElement(By.cssSelector
                ("body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0")).click();

        Boolean validarEmail = compararCelulasDaTabela(email);


        Assert.assertTrue(validarEmail);


//        List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
//
//        System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
//
//        for (LogEntry entry : entries) {
//            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
//
//        }
    }

    @Test
    public void testeDeveRetonarErrorCriarUsuarioComCamposVazios() {

        driver.findElement(By.cssSelector
                ("body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0")).click();

        String url = driver.getCurrentUrl();

        Assert.assertEquals("https://itera-qa.azurewebsites.net/Customer/Create", url);
    }

    @Test
    public void testeDeletarUsuario() {

        driver.findElement(By.cssSelector("body > div > div > p:nth-child(4) > a")).click();
        String email= faker.internet().emailAddress();
        driver.findElement(By.id("Name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("Company")).sendKeys(faker.company().name());
        driver.findElement(By.id("Address")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.id("City")).sendKeys(faker.address().city());
        driver.findElement(By.id("Phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.cssSelector("[value=\"Create\"]")).click();

        driver.findElement(By.id("searching")).sendKeys(email);
        driver.findElement(By.cssSelector
                ("body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0")).click();

        driver.findElement(By.cssSelector
                ("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger")).click();
        driver.findElement(By.cssSelector("[value=\"Delete\"]")).click();

        driver.findElement(By.id("searching")).sendKeys(email);
        driver.findElement(By.cssSelector
                ("body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0")).click();

        Boolean validarEmail = compararCelulasDaTabela(email);


        Assert.assertFalse(validarEmail);
    }

    @Test
    public void testeDeveAtualizarNome() {

        driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[7]/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div/p/a[1]")).click();
        driver.findElement(By.id("Name")).clear();
        driver.findElement(By.id("Name")).sendKeys("Rawad");
        driver.findElement((By.xpath("/html/body/div/form/div/div[7]/div/input"))).click();
        String nome = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[1]")).getText();

        Assert.assertEquals("Rawad", nome);
    }

    @Test
    public void testeDeveListarUsuario() {

        driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[7]/a[2]")).click();

        String url = driver.getCurrentUrl();

        Assert.assertEquals("https://itera-qa.azurewebsites.net/Customer/Details/", url.substring(0, url.length() - 4));
    }
}
