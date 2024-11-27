package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public void mouseHoverToElement(By by){
        driver.findElement(by);
    }
    public void mouseHoverToElementAndClick(By by){
        driver.findElement(by).click();
    }

    public void selectByValueFromDropDown(By by, String value){
        WebElement dropdown = driver.findElement(by);
        //Create the object of Select class
        Select select = new Select(dropdown);
        // Select by visible text
        select.selectByVisibleText(value);
    }

    //This method will verify text
    public void verifyTest(String displayMessage, String expectedText, String actualText){
        Assert.assertEquals(displayMessage,expectedText,actualText);

    }

}
