package org.lambdatest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void GitHubTitleTest() {
        Reporter.log(String.format("GitHub Test Started on thread %s", Thread.currentThread().getId()), true);
        getDriver().navigate().to("https://github.com/");
        Assert.assertEquals(getDriver().getTitle(), "GitHub");
        Reporter.log(String.format("GitHub Test Ended on thread %s", Thread.currentThread().getId()), true);
    }

    @Test
    public void GmailTitleTest() {
        Reporter.log(String.format("Gmail Test Started on thread %s", Thread.currentThread().getId()), true);
        getDriver().navigate().to("https://www.gmail.com/");
        Assert.assertEquals(getDriver().getTitle(), "Gmail");
        Reporter.log(String.format("Gmail Test Ended on thread %s", Thread.currentThread().getId()), true);
    }
}
