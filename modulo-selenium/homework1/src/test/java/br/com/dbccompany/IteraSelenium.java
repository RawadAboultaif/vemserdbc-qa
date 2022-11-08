package br.com.dbccompany;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IteraSelenium {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void abrirNavegador() {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @After
    public void fecharNavegador() {
        driver.quit();
    }

    @Test
    public void testeVerificarEmailInserido() throws InterruptedException {

        driver.findElement(By.cssSelector("[id=\"name\"]")).sendKeys("Testando");
        driver.findElement(By.cssSelector("[id=\"phone\"]")).sendKeys("99999999");
        driver.findElement(By.cssSelector("[id=\"email\"]")).sendKeys("Testando@.com");
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys("Testando");
        driver.findElement(By.cssSelector("[id=\"address\"]")).sendKeys("Testando");
        driver.findElement(By.cssSelector("body > div > div:nth-child(3) > div.card-body > button"))
                .click();

        try {
            wait.until(ExpectedConditions.elementToBeClickable
                    (By.cssSelector("body > div > div:nth-child(3) > div.card-body > button")));
            System.out.println("Elemento é clicavel");
        }
        catch(TimeoutException e) {
            System.out.println("Elemento nao é clicavel");
        }
    }

    @Test
    public void testeValidarCheckInputsOptions() {
        driver.findElement(By.cssSelector("[id=\"female\"]")).click();
        driver.findElement(By.cssSelector("[id=\"male\"]")).click();

        Boolean opcaoMale = driver.findElement(By.cssSelector("[id=\"male\"]")).isSelected();
        Boolean opcaoFemale = driver.findElement(By.cssSelector("[id=\"female\"]")).isSelected();

        Assert.assertTrue(opcaoMale^opcaoFemale);
    }

    @Test
    public void testeValidarSelectBox() {

        driver.findElement(By.cssSelector("[id=\"monday\"]")).click();
        driver.findElement(By.cssSelector("[id=\"tuesday\"]")).click();
        driver.findElement(By.cssSelector("[id=\"wednesday\"]")).click();
        driver.findElement(By.cssSelector("[id=\"thursday\"]")).click();
        driver.findElement(By.cssSelector("[id=\"friday\"]")).click();
        driver.findElement(By.cssSelector("[id=\"saturday\"]")).click();
        driver.findElement(By.cssSelector("[id=\"sunday\"]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"monday\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"tuesday\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"wednesday\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"thursday\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"friday\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"saturday\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id=\"sunday\"]")).isSelected());
    }

    @Test
    public void testarOptionBox() {
        WebElement selectElement = driver.findElement(By.className("custom-select"));

        Select select = new Select(selectElement);
        select.selectByVisibleText("Turkey");

        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Turkey");
    }

    @Test
    public void testeValidarCheckInputsRadio() {
        driver.findElement(By.cssSelector("label[for=\"1year\"]")).click();
        driver.findElement(By.cssSelector("label[for=\"2years\"]")).click();
        driver.findElement(By.cssSelector("label[for=\"3years\"]")).click();
        driver.findElement(By.cssSelector("label[for=\"4years\"]")).click();

    }

    @Test
    public void testarUploadFile() {
        WebElement chooseFile = driver.findElement(By.id("inputGroupFile02"));
        chooseFile.sendKeys("C:/Users/rawad.yehia/Desktop/dePrimeira.webp");

        String divText = driver.findElement(By.id("file-upload-button")).getAttribute("title");

        System.out.println(divText);
    }
}
