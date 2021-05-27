package RegistrationTests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());


    @Test
    public void testRegistrationValid() {
        //Setup browser
        File chromeFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //YOUR PERSONAL INFORMATION
        try {
            webDriver.get("http://automationpractice.com");
            logger.info("Open url - http://automationpractice.com");
        } catch (Exception e) {
            logger.error("Can't open browser");
            Assert.fail("Can't open browser");
        }

        webDriver.findElement(By.xpath("//a[@class='login']")).click();
        logger.info("Click login - //a[@class='login']");
        webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("resyniffa-2634590@yopmail.com");
        logger.info("Input email - resyniffa-2590@yopmail.com");
        webDriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        logger.info("Click submit button - //button[@id='SubmitCreate']");
        webDriver.findElement(By.xpath("//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]")).click();
        logger.info("Click account create form");
        webDriver.findElement(By.id("customer_firstname")).sendKeys("Dmytro");
        logger.info("Input customer firstname - Dmytro");
        webDriver.findElement(By.id("customer_lastname")).sendKeys("Hulak");
        logger.info("Input customer lastname - Hulak");
        webDriver.findElement(By.id("email")).sendKeys("resyniffa-2590@yopmail.com");
        logger.info("Input email - resyniffa-2590@yopmail.com");
        webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("qwerty123");
        logger.info("Input password - qwerty123");
        //Date empty
        webDriver.findElement(By.id("uniform-newsletter")).click();
        logger.info("Click uniform-newsletter checkbox");
        webDriver.findElement(By.id("optin")).click();
        logger.info("Click optin checkbox");

        //YOUR ADDRESS
        webDriver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Dmytro");
        webDriver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Hulak");
        webDriver.findElement(By.xpath("//div[@class='account_creation']//p[4]//input[@type='text']")).sendKeys("street New York, 12");
        webDriver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");
        Select state = new Select(webDriver.findElement(By.id("id_state")));
        state.selectByIndex(32);
        webDriver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12390124");
        webDriver.findElement(By.id("id_country")).isDisplayed();
        Select county = new Select(webDriver.findElement(By.id("id_country")));
        county.selectByVisibleText("United States");
        webDriver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
        webDriver.findElement(By.id("alias")).sendKeys("resyniffa-2590@yopmail.com");
        webDriver.findElement(By.id("submitAccount")).click();
        webDriver.findElement(By.xpath("//div[@id='center_column']/h1")).isDisplayed();

        //Close chromedriver
        webDriver.quit();
    }
}
