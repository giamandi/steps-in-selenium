package com.seleniumeasy.test.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxElem {

    public static WebElement singleCheckBox (WebDriver driver){
        return driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
    }

    public static WebElement singleCheckBoxMessage (WebDriver driver){
        return driver.findElement(By.xpath("//div[@id='txtAge']"));
    }

    public static List<WebElement> multiCheckBox (WebDriver driver){
        return driver.findElements(By.xpath("//div//input[@type='checkbox' and @class='cb1-element']"));
    }

    public static WebElement checkUncheck (WebDriver driver){
        return driver.findElement(By.xpath("//div//input[@id='check1']"));
    }



}
