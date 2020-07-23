package com.cbt.checkboxes_dropdown_list;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Days {
    @Test
    public static void SelectRandom(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox ");
        List<WebElement> checkbox = driver.findElements(By.cssSelector("td input"));
        List<WebElement> label = driver.findElements(By.cssSelector("td label"));

        Random random = new Random();

        int count = 0;
        while (count !=3){
            int num = random.nextInt(checkbox.size()-1);
            if (checkbox.get(num).isEnabled()){
                if(label.get(num).getText().equals("Friday"))
                    count++;
            }
            checkbox.get(num).click();
            System.out.println(label.get(num).getText());
            count++;
            checkbox.get(num).click();
        }
        driver.quit();


        
    }

    }

