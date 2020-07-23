package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
    }
    List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
            "http://practice.cybertekschool.com/dropdown",
            "http://practice.cybertekschool.com/login");
    @Test
    public void ChromeDriver(){

        BrowserFactory.getDriver("chrome").get("http://practice.cybertekschool.com/");
        String title1 = BrowserFactory.getDriver("chrome").getTitle();
        StringUtility.verifyEquals(title1, BrowserFactory.getDriver("chrome").getTitle());
        BrowserFactory.getDriver("chrome").get("http://practice.cybertekschool.com/dropdown");
        String title2 = BrowserFactory.getDriver("chrome").getTitle();
        StringUtility.verifyEquals(title2, BrowserFactory.getDriver("chrome").getTitle());
        BrowserFactory.getDriver("chrome").get("http://practice.cybertekschool.com/login");
        String title3 = BrowserFactory.getDriver("chrome").getTitle();
        StringUtility.verifyEquals(title3, BrowserFactory.getDriver("chrome").getTitle());

    }

    @Test
    public void titleVerification(){
        String expectedUrl = "http://practice.cybertekschool.com/";
        String expectedTitle = "";

        for (int i =0; i<urls.size(); i++){
            BrowserFactory.getDriver("chrome").get(urls.get(i));
            System.out.println("Verifying that \\"+BrowserFactory.getDriver("chrome").getCurrentUrl()+"\"starts with\""+expectedUrl+"\"");
            StringUtility.verifyEquals(expectedUrl, BrowserFactory.getDriver("chrome").getCurrentUrl());
        if(i==0){
            expectedTitle = BrowserFactory.getDriver("chrome").getTitle();

        }
            System.out.println("Verifying that title \""+BrowserFactory.getDriver("chrome").getTitle()+"\" is equal to \""+expectedTitle+"\"");
            StringUtility.verifyEquals(expectedTitle, BrowserFactory.getDriver("chrome").getTitle());
        }

    }
    @AfterMethod
    public void tearDown(){
        BrowserFactory.closeDriver();

    }
}
