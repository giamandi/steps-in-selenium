package com.seleniumeasy.test;

import com.seleniumeasy.test.InputForms.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InputFormsTest {
    WebDriver driver;
    private JavascriptExecutor js;


    @BeforeSuite
    public void setUp() {
        String baseUrl = "https://www.seleniumeasy.com/test/";

        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(baseUrl);
        js = (JavascriptExecutor) driver;
    }


    @Test(priority = 5)
    public void expandAllLevel2() {
// close the pop-up
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.elementToBeClickable(MenuListElements.thePopUp(driver)));
        MenuListElements.thePopUp(driver).click();
// a combination of Scroll Down and Clicks with the purpose of seeing the expanded tree
        js.executeScript("arguments[0].scrollIntoView(true);", MenuListElements.inputForms(driver));
        MenuListElements.inputForms(driver).click();
        MenuListElements.datePickers(driver).click();
        js.executeScript("arguments[0].scrollIntoView(true);", MenuListElements.table(driver));
        MenuListElements.table(driver).click();
        MenuListElements.progressBarsAndSliders(driver).click();
        js.executeScript("arguments[0].scrollIntoView(true);", MenuListElements.alertsAndModals(driver));
        MenuListElements.alertsAndModals(driver).click();
        js.executeScript("arguments[0].scrollIntoView(true);", MenuListElements.listBox(driver));
        MenuListElements.listBox(driver).click();
        MenuListElements.others(driver).click();


    }

    @Test(priority = 10)
// go to first branch
    public void goToSimpleFormDemo() {
        boolean isVisible = MenuListElements.simpleFormDemo(driver).isDisplayed();
        if (!isVisible) {
            MenuListElements.inputForms(driver).click();
        }
        MenuListElements.simpleFormDemo(driver).click();
    }

    @Test(priority = 11)
    public void checkSingleInput() {
        String actualText;
        String text = "Sample text message.";
        SimpleFormElem.textBoxSingleInput(driver).sendKeys(text);
        SimpleFormElem.showMessageButton(driver).click();
        actualText = SimpleFormElem.yourMessage(driver).getText();
        Assert.assertEquals(actualText, text);
    }

    @Test(priority = 12)
    public void checkDoubleInput() {
        js.executeScript("window.scrollBy(0, 400);");
        // send Strings in both boxes
        String textA = "textA";
        String textB = "textB";
        SimpleFormElem.enterA(driver).sendKeys(textA);
        SimpleFormElem.enterB(driver).sendKeys(textB);
        SimpleFormElem.getTotalButton(driver).click();
        String actual = SimpleFormElem.getTotalValue(driver).getText();
        Assert.assertEquals(actual, "NaN");
        // delete one of the Strings
        SimpleFormElem.enterA(driver).clear();
        SimpleFormElem.getTotalButton(driver).click();
        actual = SimpleFormElem.getTotalValue(driver).getText();
        Assert.assertEquals(actual, "NaN");
        // put a numerical value and clear the second box
        textA = "1";
        SimpleFormElem.enterA(driver).sendKeys(textA);
        SimpleFormElem.enterB(driver).clear();
        SimpleFormElem.getTotalButton(driver).click();
        actual = SimpleFormElem.getTotalValue(driver).getText();
        Assert.assertEquals(actual, "NaN");
        // numarical values in both text-boxes
        textB = "2";
        SimpleFormElem.enterB(driver).sendKeys(textB);
        SimpleFormElem.getTotalButton(driver).click();
        actual = SimpleFormElem.getTotalValue(driver).getText();
        Assert.assertEquals(actual, "3");
    }

    @Test(priority = 20)
    public void goToCheckBoxDemo() {
        boolean isVisible = MenuListElements.checkBoxDemo(driver).isDisplayed();
        if (!isVisible) {
            MenuListElements.inputForms(driver).click();
        }
        MenuListElements.checkBoxDemo(driver).click();
    }


    @Test(priority = 21)
    public void simpleCheckbox() {
    //select
        WebDriverWait wait = new WebDriverWait(driver,1);
        CheckBoxElem.singleCheckBox(driver).click();
        wait.until(ExpectedConditions.visibilityOf(CheckBoxElem.singleCheckBoxMessage(driver)));
        boolean messageIsShown = CheckBoxElem.singleCheckBoxMessage(driver).isDisplayed();
        Assert.assertTrue(messageIsShown);
    //deselect
        CheckBoxElem.singleCheckBox(driver).click();
        messageIsShown = CheckBoxElem.singleCheckBoxMessage(driver).isDisplayed();
        Assert.assertFalse(messageIsShown);
    }

    @Test(priority = 22)
    public void multiCheckbox() {
        js.executeScript("window.scrollBy(0, 400);");
        int size = CheckBoxElem.multiCheckBox(driver).size();
        SoftAssert sa = new SoftAssert();
        String checkUncheckValue;
        // check all the options, one by one. the button changes its value from Check All to Uncheck All
        for (int i = 0; i < size; i++) {
            CheckBoxElem.multiCheckBox(driver).get(i).click();
            checkUncheckValue = CheckBoxElem.checkUncheck(driver).getAttribute("value");
            if (i < (size - 1)) {
                sa.assertEquals(checkUncheckValue, "Check All");
            } else {
                sa.assertEquals(checkUncheckValue, "Uncheck All");
            }
        }
        // press the button Uncheck All and check if all the options are deselected
        CheckBoxElem.checkUncheck(driver).click();
        boolean checkBoxIsChecked;
        for (int i = 0; i < size; i++) {
            checkBoxIsChecked = CheckBoxElem.multiCheckBox(driver).get(i).isSelected();
            sa.assertFalse(checkBoxIsChecked);
        }
        // press the button Check All and check if all the options are selected
        CheckBoxElem.checkUncheck(driver).click();
        for (int i = 0; i < size; i++) {
            checkBoxIsChecked = CheckBoxElem.multiCheckBox(driver).get(i).isSelected();
            sa.assertTrue(checkBoxIsChecked);
        }

        sa.assertAll();
    }


    @Test(priority = 25)
    public void multiCheckboxDefect() {
// this needs better testing handling. will be marked as passed (for the moment). will throw an exception.

        // select the first checkbox in simple checkbox section
        CheckBoxElem.singleCheckBox(driver).click();
        // select first 3 options (except the final one) in multiple checkbox section. the button labeling is wrong:
        // Actual: Uncheck All (although there one option unselected
        // Expected: Check All
        int size = CheckBoxElem.multiCheckBox(driver).size();
        SoftAssert sa = new SoftAssert();
        String checkUncheckValue;
        for (int i = 0; i < size; i++) {
            CheckBoxElem.multiCheckBox(driver).get(i).click();
            checkUncheckValue = CheckBoxElem.checkUncheck(driver).getAttribute("value");
            if (i < (size - 1)) {
                sa.assertEquals(checkUncheckValue, "Check All");
            } else {
                sa.assertEquals(checkUncheckValue, "Uncheck All");
            }
        }
        // sa.assertAll();
        // to add a print-screen, open a defect or take an initiative.

    }

    @Test(priority = 30)
    public void goToRadioButtonsDemo() {
        boolean isVisible = MenuListElements.radioButtonsDemo(driver).isDisplayed();
        if (!isVisible) {
            MenuListElements.inputForms(driver).click();
        }
        MenuListElements.radioButtonsDemo(driver).click();
    }


    @Test(priority = 31)
    public void radioButtons() {
        js.executeScript("window.scrollBy(0, 200);");
        String noValue = "Radio button is Not checked";
        String valueMale = "Radio button 'Male' is checked";
        String valueFemale = "Radio button 'Female' is checked";
        String actualValue;
        // check for first possible value
        RadioButtonsElem.checkValueBtn(driver).click();
        actualValue = RadioButtonsElem.radioValue(driver).getText();
        Assert.assertEquals(actualValue, noValue);
        // select the radio, but without pressing the button
        RadioButtonsElem.radioMale(driver).click();
        RadioButtonsElem.radioFemale(driver).click();
        actualValue = RadioButtonsElem.radioValue(driver).getText();
        Assert.assertEquals(actualValue, noValue);
        // check both possible values
        RadioButtonsElem.checkValueBtn(driver).click();
        actualValue = RadioButtonsElem.radioValue(driver).getText();
        Assert.assertEquals(actualValue, valueFemale);
        RadioButtonsElem.radioMale(driver).click();
        RadioButtonsElem.checkValueBtn(driver).click();
        actualValue = RadioButtonsElem.radioValue(driver).getText();
        Assert.assertEquals(actualValue, valueMale);
    }

    @Test(priority = 32)
    public void radioButtonsGroup() {
        // defining the expected values
        String[] sexExp = {
                "Sex :",        //0
                "Sex : Male",   //1
                "Sex : Female"  //2
        };

        String[] ageExp = {
                "Age group:",         //0
                "Age group: 0 - 5",   //1
                "Age group: 5 - 15",  //2
                "Age group: 15 - 50"  //3
        };

        // getting the values, splitting the text in 2 Strings and asserting both values
        RadioButtonsElem.valuesBtnGroup(driver).click();
        String valuesActual = RadioButtonsElem.valuesGroup(driver).getText();
        String[] stringValues = valuesActual.split("\\n");
        Assert.assertEquals(stringValues[0], sexExp[0]);
        Assert.assertEquals(stringValues[1], ageExp[0]);
        // click and assert
        RadioButtonsElem.radioMaleGroup(driver).click();
        RadioButtonsElem.ageOneGroup(driver).click();
        RadioButtonsElem.valuesBtnGroup(driver).click();
        valuesActual = RadioButtonsElem.valuesGroup(driver).getText();
        stringValues = valuesActual.split("\\n");
        Assert.assertEquals(stringValues[0], sexExp[1]);
        Assert.assertEquals(stringValues[1], ageExp[1]);
        // click and assert
        RadioButtonsElem.radioFemaleGroup(driver).click();
        RadioButtonsElem.ageThreeGroup(driver).click();
        RadioButtonsElem.valuesBtnGroup(driver).click();
        valuesActual = RadioButtonsElem.valuesGroup(driver).getText();
        stringValues = valuesActual.split("\\n");
        Assert.assertEquals(stringValues[0], sexExp[2]);
        Assert.assertEquals(stringValues[1], ageExp[3]);
        // click and assert
        RadioButtonsElem.radioMaleGroup(driver).click();
        RadioButtonsElem.valuesBtnGroup(driver).click();
        valuesActual = RadioButtonsElem.valuesGroup(driver).getText();
        stringValues = valuesActual.split("\\n");
        Assert.assertEquals(stringValues[0], sexExp[1]);
        Assert.assertEquals(stringValues[1], ageExp[3]);
        // click and assert
        RadioButtonsElem.radioFemaleGroup(driver).click();
        RadioButtonsElem.ageTwoGroup(driver).click();
        RadioButtonsElem.ageThreeGroup(driver).click();
        RadioButtonsElem.valuesBtnGroup(driver).click();
        valuesActual = RadioButtonsElem.valuesGroup(driver).getText();
        stringValues = valuesActual.split("\\n");
        Assert.assertEquals(stringValues[0], sexExp[2]);
        Assert.assertEquals(stringValues[1], ageExp[3]);
    }

    @Test(priority = 40)
    public void goToDropdownLists() {
        boolean isVisible = MenuListElements.selectDropdownList(driver).isDisplayed();
        if (!isVisible) {
            MenuListElements.inputForms(driver).click();
        }
        MenuListElements.selectDropdownList(driver).click();
    }

    @Test(priority = 41)
    public void simpleList() {
        Select select = new Select(SelectDropdownList.simpleList(driver));
        // check displayed values
        String displayedText = select.getFirstSelectedOption().getText();
        String yourSelection = SelectDropdownList.simpleListValue(driver).getText();
        Assert.assertEquals(displayedText, "Please select");
        Assert.assertEquals(yourSelection, "");
        // selecting the options using Select class and asserting the values
        select.selectByIndex(1);
        displayedText = select.getFirstSelectedOption().getText();
        yourSelection = SelectDropdownList.simpleListValue(driver).getText();
        Assert.assertEquals(displayedText, "Sunday");
        Assert.assertEquals(yourSelection, "Day selected :- " + displayedText);
        // selecting the options using Select class and asserting the values
        select.selectByValue("Friday");
        displayedText = select.getFirstSelectedOption().getText();
        yourSelection = SelectDropdownList.simpleListValue(driver).getText();
        Assert.assertEquals(displayedText, "Friday");
        Assert.assertEquals(yourSelection, "Day selected :- " + displayedText);
        // selecting the options using Select class and asserting the values
        select.selectByVisibleText("Thursday");
        displayedText = select.getFirstSelectedOption().getText();
        yourSelection = SelectDropdownList.simpleListValue(driver).getText();
        Assert.assertEquals(displayedText, "Thursday");
        Assert.assertEquals(yourSelection, "Day selected :- " + displayedText);

    }

    @Test(priority = 42)
    public void multiList() {
        /*
         * in order to select the options in the list , there will be no effect (no selection) by using Select class
         */

        js.executeScript("window.scrollBy(0, 300);");
        Actions action = new Actions(driver);
        List<WebElement> optionsList = SelectDropdownList.multiList(driver);
        int size = optionsList.size();
        String[] valueExp = new String[size];
        String actualText, expTextAllOpt,
               expTextFirstOpt = "First selected option is : ";
        //saving all possible values as expected values with indexes. this will be concatenated with a text message later on
        for (int i = 0; i < size; i++) {
            valueExp[i] = optionsList.get(i).getText();
        }
        // clicking in the list, without pressing CTRL key
        action.click(optionsList.get(1)).click(optionsList.get(4)).perform();
        action.click(SelectDropdownList.firstSelectedBtn(driver)).perform();
        actualText = SelectDropdownList.multiMessage(driver).getText();
        Assert.assertEquals(actualText, expTextFirstOpt+valueExp[4]);
        action.click(SelectDropdownList.allSelectedBtn(driver)).perform();
        actualText = SelectDropdownList.multiMessage(driver).getText();
        expTextAllOpt = "Options selected are : " + valueExp[4];
        Assert.assertEquals(actualText, expTextAllOpt);
        // with CTRL. optionsList.get(4) is already selected (previous step)
        action.keyDown(Keys.CONTROL).click(optionsList.get(1)).click(optionsList.get(2)).click(optionsList.get(0)).keyUp(Keys.CONTROL).perform();
        action.click(SelectDropdownList.firstSelectedBtn(driver)).perform();
        actualText = SelectDropdownList.multiMessage(driver).getText();
        Assert.assertEquals(actualText, expTextFirstOpt+valueExp[4]);
        action.click(SelectDropdownList.allSelectedBtn(driver)).perform();
        actualText = SelectDropdownList.multiMessage(driver).getText();
        expTextAllOpt = "Options selected are : " + valueExp[4] + "," + valueExp[1] + "," + valueExp[2] + "," + valueExp[0];
        Assert.assertEquals(actualText, expTextAllOpt);
        //deselect one option
        action.keyDown(Keys.CONTROL).click(optionsList.get(4)).keyUp(Keys.CONTROL).perform();
        action.click(SelectDropdownList.firstSelectedBtn(driver)).perform();
        actualText = SelectDropdownList.multiMessage(driver).getText();
        Assert.assertEquals(actualText, expTextFirstOpt+valueExp[1]);
        action.click(SelectDropdownList.allSelectedBtn(driver)).perform();
        actualText = SelectDropdownList.multiMessage(driver).getText();
        expTextAllOpt = "Options selected are : " + valueExp[1] + "," + valueExp[2] + "," + valueExp[0];
        Assert.assertEquals(actualText, expTextAllOpt);

    }

    @Test(priority = 50)
    public void goToInputFormSubmit() {
        boolean isVisible = MenuListElements.inputFormSubmit(driver).isDisplayed();
        if (!isVisible) {
            MenuListElements.inputForms(driver).click();
        }
        MenuListElements.inputFormSubmit(driver).click();
    }



    @Test(priority = 51)
    public void inputFormWithoutValidations() {
// the form validations aren't working
        Actions action = new Actions(driver);
        Select selState = new Select(InputFormSubmit.state(driver));

        action.click(InputFormSubmit.firstName(driver)).sendKeys("Thomas A.").perform();
        action.click(InputFormSubmit.lastName(driver)).sendKeys("Anderson").perform();
        action.click(InputFormSubmit.email(driver)).sendKeys("one@defaultdomain.xyz").perform();
        action.click(InputFormSubmit.phone(driver)).sendKeys("01237890").perform();
        action.click(InputFormSubmit.address(driver)).sendKeys("1st, Main Street").perform();
        action.click(InputFormSubmit.city(driver)).sendKeys("Castle Rock").perform();
        js.executeScript("arguments[0].scrollIntoView(true);", InputFormSubmit.state(driver));
        selState.selectByVisibleText("Maine");
        action.click(InputFormSubmit.zipCode(driver)).sendKeys("014785").perform();
        action.click(InputFormSubmit.domainName(driver)).sendKeys("defaultdomain").perform();
        js.executeScript("arguments[0].scrollIntoView(true);", InputFormSubmit.send(driver));
        action.click(InputFormSubmit.haveHostingNo(driver)).perform();
        action.click(InputFormSubmit.haveHostingYes(driver)).perform();
        //resize 1
        js.executeScript("arguments[0].setAttribute('style', 'margin: 0px; width: 356px; height: 129px;')", InputFormSubmit.projectDesc(driver));
        action.click(InputFormSubmit.projectDesc(driver)).sendKeys(SomeMethods.textBlock()).perform();
        //resize 2
        js.executeScript("arguments[0].setAttribute('style', 'margin: 0px; width: 429px; height: 225px;')", InputFormSubmit.projectDesc(driver));
        action.click(InputFormSubmit.send(driver)).perform();
        // after submitting the form, the elements do not become Stale
    }

    @Test(priority = 60)
    public void goToAjaxFormSubmit() {
        boolean isVisible = MenuListElements.ajaxFormSubmit(driver).isDisplayed();
        if (!isVisible) {
            MenuListElements.inputForms(driver).click();
        }
        MenuListElements.ajaxFormSubmit(driver).click();
    }

    @Test(priority = 61)
    public void ajaxFormSubmit() {
        String nameStyleAct;
        String nameStyleExp = "border: 1px solid rgb(255, 0, 0);";
        WebDriverWait wait = new WebDriverWait(driver, 1);

        // check the validation on Name attribute
        nameStyleAct = AjaxFormSubmit.name(driver).getAttribute("style");
        Assert.assertEquals(nameStyleAct, "");
        AjaxFormSubmit.submitBtn(driver).click();
        wait.until(ExpectedConditions.attributeContains(AjaxFormSubmit.name(driver), "style", "rgb(255"));
        nameStyleAct = AjaxFormSubmit.name(driver).getAttribute("style");
        Assert.assertEquals(nameStyleAct, nameStyleExp);

        driver.navigate().refresh();
        //change the text-box size
        js.executeScript("window.scrollBy(0, 400);");
        js.executeScript("arguments[0].setAttribute('style', 'margin: 0px -17.5px 0px 0px; width: 750px; height: 300px;');",
                AjaxFormSubmit.text(driver));
        AjaxFormSubmit.name(driver).click();
        AjaxFormSubmit.name(driver).sendKeys("this is a sample title");
        AjaxFormSubmit.text(driver).click();
        AjaxFormSubmit.text(driver).sendKeys(SomeMethods.textBlock());
        AjaxFormSubmit.submitBtn(driver).click();
        new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(AjaxFormSubmit.loading(driver)));
        String loadingGif = AjaxFormSubmit.loading(driver).getAttribute("src");
        String loadingMessage = AjaxFormSubmit.submitControl(driver).getText();

        boolean submitBtnPresent;
        try {
            AjaxFormSubmit.submitBtn(driver).getText();
            submitBtnPresent = true;
        } catch (NoSuchElementException e) {
            submitBtnPresent = false;
        }
        String loadedMessage = AjaxFormSubmit.submitControl(driver).getText();
        Assert.assertEquals(loadingGif, AjaxFormSubmit.loadingGif());
        Assert.assertEquals(loadingMessage, AjaxFormSubmit.loadingMessage());
        Assert.assertFalse(submitBtnPresent);
        Assert.assertEquals(loadedMessage, AjaxFormSubmit.loadedMessage());
    }

    @Test(priority = 70)
    public void goToJqSelectDropdown() {
        boolean isVisible = MenuListElements.jQuerySelectDropdown(driver).isDisplayed();
        if (!isVisible) {
            MenuListElements.inputForms(driver).click();
        }
        MenuListElements.jQuerySelectDropdown(driver).click();
    }

    @Test(priority = 71)
    public void simpleAndMultiSelect(){
 /*
  *  Simple Select
  */
        String valueText;
        int size;
        boolean optionIsHighlighted;
        Actions action = new Actions(driver);
        Select select = new Select(SelectDropdownJQ.simpleSelect(driver));

        action.click(SelectDropdownJQ.simpleSelectExpandBtn(driver)).perform();
        size = SelectDropdownJQ.simpleResultSearch(driver).size();
        Assert.assertTrue(size > 2);
        // ignoring index[0]. it's an empty value
        valueText = SelectDropdownJQ.simpleResultSearch(driver).get(1).getText();
        action.sendKeys(SelectDropdownJQ.simpleInputSearch(driver), Keys.ARROW_DOWN).perform();
        action.sendKeys(SelectDropdownJQ.simpleInputSearch(driver), Keys.ENTER).perform();
        Assert.assertEquals(select.getFirstSelectedOption().getText(), valueText);
        // checking "no results found"
        action.click(SelectDropdownJQ.simpleSelectExpand(driver)).perform();
        action.sendKeys(SelectDropdownJQ.simpleInputSearch(driver), "a", "s").perform();
        size = SelectDropdownJQ.simpleResultSearch(driver).size();
        valueText = SelectDropdownJQ.simpleResultSearch(driver).get(0).getText();
        Assert.assertEquals(size, 1);
        Assert.assertEquals(valueText, "No results found");
        // search for a different value
        SomeMethods.pressBackspaceKey(driver, 1);
        action.sendKeys(SelectDropdownJQ.simpleInputSearch(driver), "n").perform();
        size = SelectDropdownJQ.simpleResultSearch(driver).size();
        Assert.assertTrue(size > 1);
        // pressing Escape button and starting again searching for the same value. assessing if it's highlighted
        action.sendKeys(SelectDropdownJQ.simpleInputSearch(driver), Keys.ESCAPE).perform();
        action.click(SelectDropdownJQ.simpleSelectExpand(driver)).perform();
        action.sendKeys(SelectDropdownJQ.simpleInputSearch(driver), "an").perform();
        optionIsHighlighted = SelectDropdownJQ.simpleResultSearch(driver).get(0).getAttribute("class").contains("highlighted");
        Assert.assertTrue(optionIsHighlighted);
        // going to the last option. assessing if it's highlighted
        size = SelectDropdownJQ.simpleResultSearch(driver).size();
        SomeMethods.moveDownWithEnter(driver, (size - 1), false);
        optionIsHighlighted = SelectDropdownJQ.simpleResultSearch(driver).get(size - 1).getAttribute("class").contains("highlighted");
        Assert.assertTrue(optionIsHighlighted);
        // and selecting it
        valueText = SelectDropdownJQ.simpleResultSearch(driver).get(size - 1).getText();
        action.sendKeys(SelectDropdownJQ.simpleInputSearch(driver), Keys.ENTER).perform();
        size = select.getAllSelectedOptions().size();
        Assert.assertEquals(size, 1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), valueText);


        /*
         *  Multi Select. using Actions class
         */
        // search by first letters. select the value by pressing Enter key
        action.click(SelectDropdownJQ.multiSelectSearch(driver)).sendKeys("alas").sendKeys(Keys.ENTER).perform();
        // search by middle letters. select the value by clicking it.
        action.click(SelectDropdownJQ.multiSelectSearch(driver)).sendKeys("liforn").perform();
        action.click(SelectDropdownJQ.multiSelectSearchValues(driver).get(0)).perform();
        // search by final letters. select the value by pressing Enter key
        action.click(SelectDropdownJQ.multiSelectSearch(driver)).sendKeys("ainE").sendKeys(Keys.ENTER).perform();
        // search by middle letters. select the value by clicking it.
        action.click(SelectDropdownJQ.multiSelectSearch(driver)).sendKeys("Wyoming").perform();
        action.click(SelectDropdownJQ.multiSelectSearchValues(driver).get(0)).perform();
        // assert for 4 selected values
        Select multiSelect = new Select(SelectDropdownJQ.multiSelect(driver));
        Assert.assertEquals(multiSelect.getAllSelectedOptions().size(), 4);
        // check the values in Select
        for (int i = 0; i < multiSelect.getAllSelectedOptions().size(); i++){
            Assert.assertEquals(SelectDropdownJQ.multiSelectedValuesDelete(driver).get(i).getText() +     // x //
                                multiSelect.getAllSelectedOptions().get(i).getText(),           // value from Select //
                                SelectDropdownJQ.multiSelectedValues(driver).get(i).getText()
            );
        }
        //delete the 4th value by using backspace
        action.click(SelectDropdownJQ.multiSelectSearch(driver)).perform();
        SomeMethods.pressBackspaceKey(driver,1);
        //delete first selected values by clicking "x"
        action.click(SelectDropdownJQ.multiSelectedValuesDelete(driver).get(0)).perform();
        action.sendKeys(Keys.ESCAPE).perform();
        // Assert for 2 remaining selected values
        Assert.assertEquals(multiSelect.getAllSelectedOptions().size(), 2);
        System.out.println();
    }


    @Test(priority = 72)
    public void disabledValuesAndCategorySelect() {
 /*
 *     Drop Down with Disabled values
 */
        js.executeScript("arguments[0].scrollIntoView(true);", SelectDropdownJQ.dropDownDisExpand(driver));
        // check if a value is already selected
        Select select = new Select (SelectDropdownJQ.dropDownDis(driver));
        Assert.assertEquals(select.getFirstSelectedOption().getText(), SelectDropdownJQ.dropDownDisExpand(driver).getText());
        // select the same value again
        Actions action = new Actions(driver);
        action.click(SelectDropdownJQ.dropDownDisExpandBtn(driver)).perform();
        action.click(SelectDropdownJQ.dropDownDisSearchValues(driver).get(0)).perform();
        Assert.assertEquals(select.getFirstSelectedOption().getText(), SelectDropdownJQ.dropDownDisExpand(driver).getText());
        // are there option not click-able? if yes, click only the first one.
        action.click(SelectDropdownJQ.dropDownDisExpandBtn(driver)).perform();
        int counter = 0;
        for (int i= 0; i < SelectDropdownJQ.dropDownDisSearchValues(driver).size(); i++){
           try{
               if (SelectDropdownJQ.dropDownDisSearchValues(driver).get(i).getAttribute("aria-disabled").equals("true")){
                   counter++;
                   action.click(SelectDropdownJQ.dropDownDisSearchValues(driver).get(i));
               }
           } catch (NullPointerException ignored){
               System.out.println("disabledValuesAndCategorySelect(); found enabled option instead of disabled.");
           }
           if (counter > 1){
               break;
           }
        }

        action.doubleClick(SelectDropdownJQ.dropDownDisExpandBtn(driver)).perform();
        action.click(SelectDropdownJQ.dropDownDisSearchBox(driver)).perform();
        action.sendKeys(SelectDropdownJQ.dropDownDisSearchBox(driver), "puerto").sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Puerto Rico");

  /*
  * Drop-down with Category related options
  */
        Select dropCategory = new Select(SelectDropdownJQ.dropDownCategory(driver));
        String valueText;
        boolean optGroup = false;
        int countOpt = 0;
        int size = SelectDropdownJQ.dropDownCategoryAll(driver).size();
// select the second option from each category where possible.
        SelectDropdownJQ.dropDownCategory(driver).click();
        for (int i = 0; i < size; i++){
            if (SelectDropdownJQ.dropDownCategoryAll(driver).get(i).getTagName().equals("optgroup")){
                optGroup = true;
            }
            if (optGroup &&
                SelectDropdownJQ.dropDownCategoryAll(driver).get(i).getTagName().equals("option")){
                countOpt ++;
            }

            if (optGroup && (countOpt==2)){
                valueText = SelectDropdownJQ.dropDownCategoryAll(driver).get(i).getText();
                SelectDropdownJQ.dropDownCategoryAll(driver).get(i).click();
                Assert.assertEquals(dropCategory.getFirstSelectedOption().getText(), valueText);

                optGroup = false;
                countOpt = 0;
                SelectDropdownJQ.dropDownCategory(driver).click();
            }
            SelectDropdownJQ.dropDownCategory(driver).click();
        }
    }

    @AfterSuite
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}