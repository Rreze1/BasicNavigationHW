package com.cbt.BasicNavigationHomework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTestCase {
    @Test
    public void NavigationTCase(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.google.com/");
       String title = driver.getTitle();
       driver.get("https://www.ebay.com/");
       String title1 = driver.getTitle();
       driver.navigate().back();
       Assert.assertEquals("https://www.google.com/", driver.getCurrentUrl());
       driver.navigate().forward();
       Assert.assertEquals("https://www.ebay.com/", driver.getCurrentUrl());
        driver.close();



    }
}
