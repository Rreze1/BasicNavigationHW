package com.cbt.BasicNavigationHomework1;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class NavigationTest1 {
    @Test
    public void testChrome(){
        BrowserFactory.getDriver("chrome").get("https://www.google.com/");
        String title = BrowserFactory.getDriver("chrome").getTitle();
        System.out.println(title);
        BrowserFactory.getDriver("chrome").get("https://www.etsy.com/");
        String title1 = BrowserFactory.getDriver("chrome").getTitle();
        System.out.println(title1);
        BrowserFactory.getDriver("chrome").navigate().back();
        StringUtility.verifyEquals(title, BrowserFactory.getDriver("chrome").getTitle());
        BrowserFactory.getDriver("chrome").navigate().forward();
        StringUtility.verifyEquals(title1, BrowserFactory.getDriver("chrome").getTitle());
    }
    @Test
    public void testFirefox(){
        BrowserFactory.getDriver("firefox").get("https://www.google.com/");
        String title = BrowserFactory.getDriver("firefox").getTitle();
        System.out.println(title);
        BrowserFactory.getDriver("firefox").get("https://www.etsy.com/");
        String title1 = BrowserFactory.getDriver("firefox").getTitle();
        System.out.println(title1);
        BrowserFactory.getDriver("firefox").navigate().back();
        StringUtility.verifyEquals(title, BrowserFactory.getDriver("chrome").getTitle());
        BrowserFactory.getDriver("firefox").navigate().back();
        BrowserFactory.getDriver("firefox").navigate().forward();
        StringUtility.verifyEquals(title1,BrowserFactory.getDriver("firefox").getTitle());

    }
    @Test
    public void testEdge(){
        BrowserFactory.getDriver("edge").get("https://www.google.com/");
        String title = BrowserFactory.getDriver("edge").getTitle();
        System.out.println(title);
        BrowserFactory.getDriver("edge").get("https://www.etsy.com/");
        String title1 = BrowserFactory.getDriver("edge").getTitle();
        System.out.println(title1);
        BrowserFactory.getDriver("edge").navigate().back();
        StringUtility.verifyEquals(title, BrowserFactory.getDriver("edge").getTitle());
        BrowserFactory.getDriver("edge").navigate().forward();
        StringUtility.verifyEquals(title1, BrowserFactory.getDriver("edge").getTitle());

    }


@AfterMethod
    public void tearDown(){
    BrowserFactory.closeDriver();
}


}
