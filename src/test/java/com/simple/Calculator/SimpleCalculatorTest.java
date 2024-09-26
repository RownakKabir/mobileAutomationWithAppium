package com.simple.Calculator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleCalculatorTest extends BaseTest {
@Test
    public void addShouldSucceseed(){
    driver.findElement(By.id("digit_7")).click();
    driver.findElement(By.id("op_add")).click();
    driver.findElement(By.id("digit_9")).click();
    driver.findElement(By.id("eq")).click();
    Assert.assertEquals(driver.findElement(By.id("result")).getText(), "16");
    takeScreenshot();
}

    @Test
    public void subShouldSucceseed(){
        driver.findElement(By.id("digit_9")).click();
        driver.findElement(By.id("op_sub")).click();
        driver.findElement(By.id("digit_7")).click();
        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "2");
        takeScreenshot();
    }

    @Test
    public void mulShouldSucceseed(){
        driver.findElement(By.id("digit_9")).click();
        driver.findElement(By.id("op_mul")).click();
        driver.findElement(By.id("digit_7")).click();
        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "63");
        takeScreenshot();
}

@Test
    public void divShouldSucceseed(){
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("op_div")).click();
        driver.findElement(By.id("digit_7")).click();
        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "5");
         takeScreenshot();
}


}

