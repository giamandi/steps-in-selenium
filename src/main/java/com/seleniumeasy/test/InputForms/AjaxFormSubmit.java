package com.seleniumeasy.test.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AjaxFormSubmit {

    public static WebElement name(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='title']"));
    }

    public static WebElement text(WebDriver driver) {
        return driver.findElement(By.xpath("//textarea[@id='description']"));
    }

    public static WebElement submitBtn(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='btn-submit']"));
    }

    public static WebElement loading(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@id='submit-control']/img"));
    }

    public static WebElement submitControl(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@id='submit-control']"));
    }

    public static String loadingGif() {
        return "https://www.seleniumeasy.com/test/LoaderIcon.gif";
    }

    public static String loadingMessage() {
        return "Ajax Request is Processing!";
    }

    public static String loadedMessage() {
        return "Form submited Successfully!";
    }

}
