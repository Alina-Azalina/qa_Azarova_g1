package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Homework2 {
            private WebDriver driver;

            @Test
            public void googleForCheese() {
                File chromeFF = new File("./drivers/chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());
                driver = new ChromeDriver();
                driver.get("https://www.google.com");
                WebElement element = driver.findElement(By.name("q"));
                element.sendKeys("Cheese!");

                element.submit();

            }
        }