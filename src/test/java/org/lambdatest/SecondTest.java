package org.lambdatest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    @Test
    public void MyntraTitleTest() {
        Reporter.log(String.format("Myntra Test Started on thread %s", Thread.currentThread().getId()), true);
        getDriver().navigate().to("https://www.myntra.com/");
        Assert.assertEquals(getDriver().getTitle(), "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra");
        Reporter.log(String.format("Myntra Test Ended on thread %s", Thread.currentThread().getId()), true);
    }

    @Test
    public void LambdaTestTitleTest() {
        Reporter.log(String.format("LambdaTest Test Started on thread %s", Thread.currentThread().getId()), true);
        getDriver().navigate().to("https://www.lambdatest.com/");
        Assert.assertEquals(getDriver().getTitle(), "Most Powerful Cross Browser Testing Tool Online | LambdaTest");
        Reporter.log(String.format("LambdaTest Test Ended on thread %s", Thread.currentThread().getId()), true);
    }

}
