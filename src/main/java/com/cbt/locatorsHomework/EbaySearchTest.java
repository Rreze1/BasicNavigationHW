package com.cbt.locatorsHomework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EbaySearchTest {
    @Test
    public void EbaySearch(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon"+ Keys.ENTER);
        driver.findElement(By.id("gh-ac")).click();
        String result = driver.findElement(By.xpath("(//h1/span)[1]")).getText().replace(",", "");
        System.out.println(result+" results");

        WebElement all = driver.findElement(By.xpath("//li[@class='srp-refine__category__item srp-refine__category__list--flush']/a"));
        all.click();

        String result2 = driver.findElement(By.xpath("//input[@type='text'])[1]")).getText().replace(",", "");
        System.out.println( result2 +" results");


    }

}
