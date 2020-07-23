package com.cbt.checkboxes_dropdown_list;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodaysDate {
    @Test
    public static void TodaysDateVerify(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement year = driver.findElement(By.id("year"));
        Select year1 = new Select(year);

        WebElement month = driver.findElement(By.id("month"));
        Select month1 = new Select(month);

        WebElement day = driver.findElement(By.id("day"));
        Select day1 = new Select(day);

        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime currentDate = LocalDateTime.now();

        Assert.assertEquals(date.format(currentDate), year1.getFirstSelectedOption().getText());
        Assert.assertEquals(date.format(currentDate), month1.getFirstSelectedOption().getText());
        Assert.assertEquals(date.format(currentDate), day1.getFirstSelectedOption().getText());
        StringUtility.verifyEquals(date.format(currentDate),
                year1.getFirstSelectedOption().getText()+ "/" +
                        month1.getFirstSelectedOption().getText()+ "/" +
                        day1.getFirstSelectedOption().getText());


        driver.close();




    }
}
