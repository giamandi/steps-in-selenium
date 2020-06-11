package com.seleniumeasy.test.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputFormSubmit {

    public static WebElement firstName(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='first_name']"));
    }

    public static WebElement lastName(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='last_name']"));
    }

    public static WebElement email(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='email']"));
    }

    public static WebElement phone(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='phone']"));
    }

    public static WebElement address(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='address']"));
    }

    public static WebElement city(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='city']"));
    }

    public static WebElement state(WebDriver driver) {
        return driver.findElement(By.xpath("//select[@name='state']"));
    }

    public static WebElement zipCode(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='zip']"));
    }

    public static WebElement domainName(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='website']"));
    }

    public static WebElement haveHostingYes(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='hosting' and @value='yes']"));
    }

    public static WebElement haveHostingNo(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='hosting' and @value='no']"));
    }

    public static WebElement projectDesc(WebDriver driver) {
        return driver.findElement(By.xpath("//textarea[@name='comment']"));
    }

    public static WebElement send(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

}
