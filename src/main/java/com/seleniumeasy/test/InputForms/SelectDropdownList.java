package com.seleniumeasy.test.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectDropdownList {

    public static WebElement simpleList (WebDriver driver){
        return driver.findElement(By.xpath("//select[@id='select-demo']"));
    }

    public static WebElement simpleListValue (WebDriver driver){
        return driver.findElement(By.xpath("//p[@class='selected-value']"));
    }

    public static List<WebElement> multiList (WebDriver driver){
        return driver.findElements(By.xpath("//select[@id='multi-select']/option"));
    }

    public static WebElement firstSelectedBtn (WebDriver driver){
        return driver.findElement(By.xpath("//button[@id='printMe']"));
    }

    public static WebElement allSelectedBtn (WebDriver driver){
        return driver.findElement(By.xpath("//button[@id='printAll']"));
    }

    public static WebElement multiMessage (WebDriver driver){
        return driver.findElement(By.xpath("//p[@class='getall-selected']"));
    }



}
