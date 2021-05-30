package RegistrationTests;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTestHW {
    public WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    @Test
public void testRegistrationValid()
    {
        File chromeFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://automationpractice.com");
        logger.info("Open url - http://automationpractice.com");

        // Starting Sign in
        webDriver.findElement(By.xpath("//a[@class='login']")).click();
        logger.info("Click ligin - //a[@class='login'");

        // add personal information
        webDriver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("xanale9907@isecv.com");
        logger.info("Input email - xanale9907@isecv.com");
        webDriver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        logger.info("Click submit button - //button[@id='SubmitCreate']");
        webDriver.findElement(By.id("customer_firstname")).sendKeys("Alina");
        logger.info("Input name - Alina");
        webDriver.findElement(By.id("customer_lastname")).sendKeys("Aza");
        logger.info("Input last name - Aza");
        webDriver.findElement(By.id("email")).sendKeys("xanale9907@isecv.com");
        logger.info("Input email - xanale9907@isecv.com");
        webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("fkbyf123");
        logger.info("Input password - fkbyf123");

        // data empty
        webDriver.findElement(By.id("uniform-newsletter")).click();
        logger.info("Click uniform-newsletter checkbox");
        webDriver.findElement(By.id("option")).click();
        logger.info("Click option checkbox");

        // address
        webDriver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Alina");
        logger.info("Input name - Alina");
        webDriver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Aza");
        logger.info("Input last name - Aza");
        webDriver.findElement(By.xpath("//div[@class='account_creation']//p[4]//input[@type='text']")).sendKeys("street New York, 12");
        logger.info("Input address - street New York, 12");
        webDriver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");
        Select state = new Select(webDriver.findElement(By.id("id_state")));
        state.selectByIndex(32);
        logger.info("Select option city - New York");
        webDriver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12390124");
        logger.info("Input postcode - 12390124");
        webDriver.findElement(By.id("id_country")).isDisplayed();
        Select county = new Select(webDriver.findElement(By.id("id_country")));
        county.selectByVisibleText("United States");
        logger.info("Select country - United States");
        webDriver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
        logger.info("Input phone number - 1234567890");
        webDriver.findElement(By.id("alias")).sendKeys("xanale9907@isecv.com");
        logger.info("Input email - xanale9907@isecv.com");
        webDriver.findElement(By.id("submitAccount")).click();
        logger.info("Click te button");
        webDriver.findElement(By.xpath("//div[@id='center_column']/h1")).isDisplayed();
        logger.info("See element //div[@id='center_column']/h1");

        // Close chrome
        webDriver.quit();

    }
}
