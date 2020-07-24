package com.cbt.BasicNavigationHomework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPractice {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }
    @Test
    public void testcase1(){
        WebElement element = driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])"));
        element.click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String response = driver.findElement(By.xpath("(//div[@class='col-sm-5']//small)[22]")).getText();
        Assert.assertEquals(response,"The date of birth is not valid");
    }

    @Test
    public void testcase2(){
        WebElement element = driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])"));
        element.click();
       Assert.assertTrue(driver.findElement(By.id("inlineCheckbox1")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.id("inlineCheckbox2")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.id("inlineCheckbox3")).isDisplayed());

    }

    @Test
    public void testcase3(){
        WebElement element = driver.findElement(By.xpath("(//li[@class='list-group-item']//a[@href='/registration_form'])"));
        element.click();
        driver.findElement(By.name("firstname")).sendKeys("a");
       WebElement response = driver.findElement(By.xpath("(//small[@class='help-block'])[2]"));
       System.out.println(response);
       Assert.assertEquals(response, "first name must be more than 2 and less than 64 characters long");


    }

    @AfterMethod
    public void shutdown() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }

}
