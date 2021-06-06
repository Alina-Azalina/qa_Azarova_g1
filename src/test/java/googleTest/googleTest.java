package googleTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class googleTest {
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    // аннотация Before
    @Before
    public void Setup() {
        //Setup browser
        File chromeFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.google.com");
    }

    @Test
    public void test() {
        // add in search field
        webDriver.findElement(By.name("q")).sendKeys("junit4" + Keys.ENTER);
        logger.info("Input value in search field - junit4");
        logger.info(webDriver.getCurrentUrl());
        WebElement element = webDriver.findElement(By.cssSelector("div[css='1'] > * h3"));
        logger.info("Search title - About - JUnit");
        Assert.assertEquals( "About - JUnit", element.getText());
        }

    // аннотация After
    @After
    public void after() {
        //Close chromedriver
        webDriver.quit();
        logger.info("Close chromedriver");
    }
}
