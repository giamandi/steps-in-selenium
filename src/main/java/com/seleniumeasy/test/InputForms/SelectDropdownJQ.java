package com.seleniumeasy.test.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectDropdownJQ {

// Single select
    public static WebElement simpleSelect (WebDriver driver){
        return driver.findElement(By.xpath("//select[@id='country']"));
    }

    public static WebElement simpleSelectExpand(WebDriver driver){
        return driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[@class = 'row'][1]//span[@role='combobox']"));
    }

    public static WebElement simpleSelectExpandBtn (WebDriver driver){
        return driver.findElement(By.xpath("//div[@class = 'col-md-6 text-left']/div[@class = 'row'][1]//b"));
    }
            // search box
    public static WebElement simpleInputSearch(WebDriver driver){
        return driver.findElement(By.xpath("//span/input[@class='select2-search__field']"));
        //xpath also used for dropDownDisSearchBox
    }
            // search box
    public static List<WebElement> simpleResultSearch (WebDriver driver){
        return driver.findElements(By.xpath("//ul[@id='select2-country-results']/li"));
    }




// Multi-Select
    public static WebElement multiSelect (WebDriver driver){
        return driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[@class='row'][2]//select"));
    }

    public static WebElement multiSelectSearch (WebDriver driver){
        return driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[@class='row'][2]//input"));
    }

    public static List<WebElement> multiSelectedValues (WebDriver driver){
        return driver.findElements(By.xpath("//div[@class='col-md-6 text-left']/div[@class='row'][2]//li[@class='select2-selection__choice']"));
    }

    public static List<WebElement> multiSelectedValuesDelete (WebDriver driver){
        return driver.findElements(By.xpath("//div[@class='col-md-6 text-left']/div[@class='row'][2]//li/span[@role='presentation']"));
    }

    public static List<WebElement> multiSelectSearchValues (WebDriver driver){
        return driver.findElements(By.xpath("//span[@class = 'select2-results']/ul/li"));
    }


// Drop-down with disabled values
    public static WebElement dropDownDis (WebDriver driver){
        return driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[@class='row'][3]//select"));
    }

    public static WebElement dropDownDisExpand (WebDriver driver){
        return driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[@class='row'][3]//span[starts-with(@id, 'select2')]"));
    }

    public static WebElement dropDownDisExpandBtn (WebDriver driver){
        return driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[@class='row'][3]//b[@role='presentation']"));
    }

    public static WebElement dropDownDisSearchBox (WebDriver driver){
        return simpleInputSearch(driver);
    }

    public static List<WebElement> dropDownDisSearchValues (WebDriver driver){
        return driver.findElements(By.xpath("//span/ul[starts-with(@id,'select2-')]/li"));
    }


// Drop-down with Category related options
    public static WebElement dropDownCategory (WebDriver driver){
        return driver.findElement(By.xpath("//select[@id='files']"));
    }

    public static List<WebElement> dropDownCategoryAll (WebDriver driver){
        return driver.findElements(By.xpath("//select[@id='files']//*"));
    }

}
