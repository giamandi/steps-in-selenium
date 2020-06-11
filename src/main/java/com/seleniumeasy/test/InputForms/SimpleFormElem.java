package com.seleniumeasy.test.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleFormElem {

// Single Input Field
    public static WebElement textBoxSingleInput(WebDriver driver){
        return driver.findElement(By.xpath("//input[@id='user-message']"));
    }

    public static WebElement showMessageButton (WebDriver driver){
        return driver.findElement(By.xpath("//button[text()='Show Message']"));
    }

    public static WebElement yourMessage(WebDriver driver){
        return driver.findElement(By.xpath("//span[@id=\"display\"]"));
    }


//  Two Input Fields
     public static WebElement enterA(WebDriver driver){
         return driver.findElement(By.xpath("//input[@id=\"sum1\"]"));
    }

    public static WebElement enterB(WebDriver driver){
        return driver.findElement(By.xpath("//input[@id=\"sum2\"]"));
    }

    public static WebElement getTotalButton(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button[text()='Get Total']"));
    }

    public static WebElement getTotalValue(WebDriver driver){
        return driver.findElement(By.xpath("//span[@id=\"displayvalue\"]"));
    }




}
