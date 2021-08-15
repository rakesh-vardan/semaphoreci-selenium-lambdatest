package org.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTestRemote {

    public WebDriver driver;

    @BeforeTest
    public void setUp() {
        try {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
            driver.get("https://lambdatest.github.io/sample-todo-app/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testScript() {
        try {
            driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).click();
            driver.findElement(By.id("sampletodotext")).clear();
            driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
            driver.findElement(By.id("addbutton")).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testMe() {
        String headerText = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(headerText, "some test");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
