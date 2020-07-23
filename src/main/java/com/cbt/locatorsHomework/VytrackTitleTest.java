package com.cbt.locatorsHomework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VytrackTitleTest {
    @Test
    public void vytrackTitleTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa3.vytrack.com/");
        String user="user1";
        String password="UserUser123";
        WebElement userInput=driver.findElement(By.id("prependedInput"));
        WebElement passwordInput=driver.findElement(By.id("prependedInput2"));
        userInput.sendKeys(user);
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement userName=driver.findElement(By.xpath("//*[@id='user-menu']/a"));
        String uName= userName.getText();
        System.out.println(uName);
        userName.click();
        Thread.sleep(1000);
        WebElement myConfiguration= driver.findElement(By.linkText("My Configuration"));
        myConfiguration.click();
        Thread.sleep(3000);
        String titleH=driver.getTitle();
        System.out.println(titleH);
        Assert.assertTrue(titleH.startsWith(uName));

        driver.close();
    }
}
