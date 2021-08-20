package org.lambdatest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void FacebookTitleTest() {
        Reporter.log(String.format("Facebook Test Started on thread %s", Thread.currentThread().getId()), true);
        getDriver().navigate().to("http://www.facebook.com");
        Assert.assertEquals(getDriver().getTitle(), "Facebook – log in or sign up");
        Reporter.log(String.format("Facebook Test Ended on thread %s", Thread.currentThread().getId()), true);
    }

    @Test
    public void GmailTitleTest() {
        Reporter.log(String.format("Gmail Test Started on thread %s", Thread.currentThread().getId()), true);
        getDriver().navigate().to("http://www.gmail.com");
        Assert.assertEquals(getDriver().getTitle(), "Gmail");
        Reporter.log(String.format("Gmail Test Ended on thread %s", Thread.currentThread().getId()), true);
    }
}
