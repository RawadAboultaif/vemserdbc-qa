package br.com.dbccompany.automationtesting.step.test;

import br.com.dbccompany.automationtesting.step.BaseTest;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class HomePageMyAccount extends BaseTest {

    Faker faker = new Faker(Locale.of("pt-Br"));

    @Test
    public void testeDeveRealizarLogin() {
        driver.findElement(By.id("menu-item-50")).click();

        driver.findElement(By.id("username")).sendKeys("rawad@teste.com");
        driver.findElement(By.id("password")).sendKeys("rawadyehia");
        driver.findElement(By.cssSelector
                ("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > input.woocommerce-Button.button")).click();

        String logout = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();

        Assert.assertEquals("Sign out", logout);
    }

    @Test
    public void testeDeveRetornarErrorCampoSenhaVazio() {

        driver.findElement(By.id("menu-item-50")).click();
        driver.findElement(By.id("username")).sendKeys("rawad@teste.com");
        driver.findElement(By.cssSelector
                ("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > input.woocommerce-Button.button")).click();

        String msgError = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")).getText();

        Assert.assertEquals("Error: Password is required.", msgError);
    }

    @Test
    public void testeDeveCadastrarNovoUsuario() {

        driver.findElement(By.id("reg_email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("reg_password")).sendKeys(faker.internet().password());
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();

        String logout = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();

        Assert.assertEquals("Sign out", logout);
    }

    @Test
    public void testeDeveRetonarErrorEmailInvalido() {

        String email = faker.internet().emailAddress();
        driver.findElement(By.id("reg_email")).sendKeys(email.substring(0, email.length() - 4));
        driver.findElement(By.id("reg_password")).sendKeys(faker.internet().password());

        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();

        String msgError = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")).getText();

        Assert.assertEquals("Error: Please provide a valid email address.", msgError);
    }

    @Test
    public void testeDeveSubscreverComSucessoComEmailValido() {

        driver.findElement(By.xpath("//*[@id=\"mc4wp-form-1\"]/div[1]/p[1]/input")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//*[@id=\"mc4wp-form-1\"]/div[1]/p[2]/input")).click();

        String msgSucesso = driver.findElement(By.xpath("//*[@id=\"mc4wp-form-1\"]/div[2]/div/p")).getText();

        Assert.assertEquals("Thank you, your sign-up request was successful! Please check your email inbox to confirm.", msgSucesso);
    }

    @Test
    public void testeDeveRetornarErrorSubscreverComEmailInvalido() throws InterruptedException {

        String email = faker.internet().emailAddress();
        WebElement campoBusca = driver.findElement(By.cssSelector("#mc4wp-form-1 > div.mc4wp-form-fields > p:nth-child(1) > input[type=email]"));
        campoBusca.sendKeys(email.substring(0, email.length() - 4));
        driver.findElement(By.xpath("//*[@id=\"mc4wp-form-1\"]/div[1]/p[2]/input")).click();

        String msgError = driver.findElement(By.xpath("//*[@id=\"mc4wp-form-1\"]/div[2]/div/p")).getText();

        Assert.assertEquals("Please provide a valid email address.", msgError);
    }
}
