package com.seleniumeasy.test.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsElem {

    // Radio Button Demo >>> section
    public static WebElement radioMale (WebDriver driver){
        return driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
    }

    public static WebElement radioFemale (WebDriver driver){
        return driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
    }

    public static WebElement checkValueBtn (WebDriver driver){
        return driver.findElement(By.xpath("//button[@id='buttoncheck']"));
    }

    public static WebElement radioValue (WebDriver driver){
        return driver.findElement(By.xpath("//p[@class='radiobutton']"));
    }


    // Group Radio Buttons Demo >>> section
    public static WebElement radioMaleGroup (WebDriver driver){
        return driver.findElement(By.xpath("//input[@value='Male' and @name='gender']"));
    }

    public static WebElement radioFemaleGroup (WebDriver driver){
        return driver.findElement(By.xpath("//input[@value='Female' and @name='gender']"));
    }

    public static WebElement ageOneGroup (WebDriver driver){
        return driver.findElement(By.xpath("//input[@name='ageGroup' and @value='0 - 5']"));
    }

    public static WebElement ageTwoGroup (WebDriver driver){
        return driver.findElement(By.xpath("//input[@name='ageGroup' and @value='5 - 15']"));
    }

    public static WebElement ageThreeGroup (WebDriver driver){
        return driver.findElement(By.xpath("//input[@name='ageGroup' and @value='15 - 50']"));
    }

    public static WebElement valuesBtnGroup (WebDriver driver){
        return driver.findElement(By.xpath("//button[@type='button' and @onclick='getValues();']"));
    }

    public static WebElement valuesGroup (WebDriver driver){
        return driver.findElement(By.xpath("//p[@class='groupradiobutton']"));
    }


}
