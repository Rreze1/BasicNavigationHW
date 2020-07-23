package com.cbt.locatorsHomework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WikipediaUrl {

    public void WikiUrl (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Selenium (software)")).click();
        String exp = "Selenium (software)";
        String actu = driver.getCurrentUrl();
        if (actu.endsWith(exp)){
            System.out.println("pass");
        }else {
            System.out.println("FAIL");
            System.out.println("actu = "+actu);
            System.out.println("exp = "+exp);


        }
        driver.close();

    }
}
