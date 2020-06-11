package com.seleniumeasy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuListElements {

    /** Returns the pop-up                */
    public static WebElement thePopUp(WebDriver driver){
        return driver.findElement(By.xpath("//div[@id='at-cv-lightbox-inner']//a[text()= 'No, thanks!']"));
    }


    /** Returns *Tree View* element: All Examples                           Tree Level 1                */
    public static WebElement allExamplesBtn(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='All Examples']"));
    }

    /** Returns *Tree View* element: Input Forms                                        Tree Level 2                */
    public static WebElement inputForms(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Input Forms']"));
    }

    /** Returns *Tree View* element: Simple Form Demo                                               Tree Level 3                */
    public static WebElement simpleFormDemo(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Simple Form Demo']"));
    }

    /** Returns *Tree View* element: Checkbox Demo                                                  Tree Level 3                */
    public static WebElement checkBoxDemo(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Checkbox Demo']"));
    }

    /** Returns *Tree View* element: Radio Buttons Demo                                             Tree Level 3                */
    public static WebElement radioButtonsDemo(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Radio Buttons Demo']"));
    }


    /** Returns *Tree View* element: Select Dropdown List                                           Tree Level 3                */
    public static WebElement selectDropdownList(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Select Dropdown List']"));
    }


    /** Returns *Tree View* element: Input Form Submit                                              Tree Level 3                */
    public static WebElement inputFormSubmit(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Input Form Submit']"));
    }
    /** Returns *Tree View* element: Ajax Form Submit                                               Tree Level 3                */
    public static WebElement ajaxFormSubmit(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Ajax Form Submit']"));
    }

    /** Returns *Tree View* element: JQuery Select dropdown                                         Tree Level 3                */
    public static WebElement jQuerySelectDropdown(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='JQuery Select dropdown']"));
    }

    /** Returns *Tree View* element: Date Pickers                                       Tree Level 2                */
    public static WebElement datePickers(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Date pickers']"));
    }

    /** Returns *Tree View* element: Bootstrap Date Picker                                          Tree Level 3                */
    public static WebElement bootstrapDatePicker(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Bootstrap Date Picker']"));
    }

    /** Returns *Tree View* element: JQuery Date Picker                                             Tree Level 3                */
    public static WebElement jqueryDatePicker(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='JQuery Date Picker']"));
    }

    /** Returns *Tree View* element: Table                                              Tree Level 2                */
    public static WebElement table(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Table']"));
    }

    /** Returns *Tree View* element: Table Pagination                                               Tree Level 3                */
    public static WebElement tablePagination(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Table Pagination']"));
    }

    /** Returns *Tree View* element: Table Data Search                                              Tree Level 3                */
    public static WebElement tableDataSearch(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Table Data Search']"));
    }

    /** Returns *Tree View* element: Table Filter                                                   Tree Level 3                */
    public static WebElement tableFilter(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[contains(text(),'Table Filter')]"));
    }

    /** Returns *Tree View* element: Table Sort & Search                                            Tree Level 3                */
    public static WebElement tableSortAndSearch(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Table Sort & Search']"));
    }

    /** Returns *Tree View* element: Table Data Download                                            Tree Level 3                */
    public static WebElement tableDataDownload(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Table Data Download']"));
    }

    /** Returns *Tree View* element: Progress Bars & Sliders                            Tree Level 2                */
    public static WebElement progressBarsAndSliders(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Progress Bars & Sliders']"));
    }

    /** Returns *Tree View* element: JQuery Download Progress bars                                  Tree Level 3                */
    public static WebElement jQueryDownloadProgressBars(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='JQuery Download Progress bars']"));
    }

    /** Returns *Tree View* element: Bootstrap Progress bar                                         Tree Level 3                */
    public static WebElement bootstrapProgressBar(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Bootstrap Progress bar']"));
    }

    /** Returns *Tree View* element: Drag & Drop Sliders                                            Tree Level 3                */
    public static WebElement dragAndDropSliders(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Drag & Drop Sliders']"));
    }

    /** Returns *Tree View* element: Alerts & Modals                                    Tree Level 2                */
    public static WebElement alertsAndModals(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Alerts & Modals']"));
    }

    /** Returns *Tree View* element: Bootstrap Alerts                                               Tree Level 3                */
    public static WebElement bootstrapAlerts(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Bootstrap Alerts']"));
    }

    /** Returns *Tree View* element: Bootstrap Modals                                               Tree Level 3                */
    public static WebElement bootstrapModals(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Bootstrap Modals']"));
    }

    /** Returns *Tree View* element: Window Popup Modal                                             Tree Level 3                */
    public static WebElement windowPopupModal(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Window Popup Modal']"));
    }

    /** Returns *Tree View* element: Progress Bar Modal                                             Tree Level 3                */
    public static WebElement progressBarModal(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Progress Bar Modal']"));
    }

    /** Returns *Tree View* element: Javascript Alerts                                              Tree Level 3                */
    public static WebElement javascriptAlerts(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Javascript Alerts']"));
    }

    /** Returns *Tree View* element: File Download                                                  Tree Level 3                */
    public static WebElement fileDownload(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='File Download']"));
    }

    /** Returns *Tree View* element: List Box                                           Tree Level 2                */
    public static WebElement listBox(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='List Box']"));
    }

    /** Returns *Tree View* element: Bootstrap List Box                                             Tree Level 3                */
    public static WebElement bootstrapListBox(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Bootstrap List Box']"));
    }

    /** Returns *Tree View* element: JQuery List Box                                                Tree Level 3                */
    public static WebElement jQueryListBox(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='JQuery List Box']"));
    }

    /** Returns *Tree View* element: Data List Filter                                               Tree Level 3                */
    public static WebElement dataListFilter(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Data List Filter']"));
    }

    /** Returns *Tree View* element: Others                                             Tree Level 2                */
    public static WebElement others(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Others']"));
    }

    /** Returns *Tree View* element: Drag and Drop                                                  Tree Level 3                */
    public static WebElement dragAndDrop(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Drag and Drop']"));
    }


    /** Returns *Tree View* element: Dynamic Data Loading                                           Tree Level 3                */
    public static WebElement dynamicDataLoading(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Dynamic Data Loading']"));
    }

    /** Returns *Tree View* element: Charts Demo                                                    Tree Level 3                */
    public static WebElement chartsDemo(WebDriver driver){
        return driver.findElement(By.xpath("//ul[@id=\"treemenu\"]//a[text()='Charts Demo']"));
    }


}
