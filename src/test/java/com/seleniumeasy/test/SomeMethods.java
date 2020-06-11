package com.seleniumeasy.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SomeMethods {

    public static String textBlock (){
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
                "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea " +
                "commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla" +
                " pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    }

    public static void pressBackspaceKey (WebDriver driver, int n){
        Actions action = new Actions (driver);
        if (n >= 1){
            for (int i = 0; i < n; i++){
                action.sendKeys(Keys.BACK_SPACE).perform();
            }
        }
    }

    public static void moveDownWithEnter (WebDriver driver, int n, boolean withEnter){
        Actions action = new Actions (driver);
        if (n >= 1){
            for (int i = 0; i < n; i++){
                action.sendKeys(Keys.ARROW_DOWN).perform();
            }
        }
        if (withEnter){
            action.sendKeys(Keys.ENTER).perform();
        }
    }


}
