package org.lambdatest;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters(value = {"browser", "gridHubURL"})
    public void setupTest(String browser, String gridHubURL) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);

        if (StringUtils.contains(gridHubURL, "LT_Grid")) {
            driver.set(new RemoteWebDriver(new URL("https://" + getUsername() + ":" + getAccessKey() + "@hub.lambdatest.com/wd/hub"), capabilities));
        } else {
            driver.set(new RemoteWebDriver(new URL(gridHubURL), capabilities));
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    private static String getAccessKey() {
        return System.getenv("LT_ACCESS_KEY") != null ? System.getenv("LT_ACCESS_KEY") : "fmDO8s7hkigdfj9S3AvsbZAtiSmjFm2yfDHPZIHPJjia7qk4yu";
    }

    private static String getUsername() {
        return System.getenv("LT_USERNAME") != null ? System.getenv("LT_USERNAME") : "rakeshbudugu";
    }

}
