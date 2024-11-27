package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        // click on consent
        clickOnElement(By.xpath("//p[normalize-space()='Consent']"));

        //Mouse Hover on the ‘Women’ Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));

        //Mouse Hover on the ‘Tops’
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        //Click on the ‘Jackets’
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select Sort By filter “Product Name”
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"));
        //Create the object of select class
        Select select = new Select(dropDown);
        //Select by visible text
        select.selectByVisibleText("Product Name");

        //Verify the product name displayed in alphabetical order
        List<WebElement> productNames = driver.findElements(By.xpath("//li//div[1]//div[1]//strong[1]/a"));

        //store product name in the actualProductName List.
        List<String> actualProductsName = new ArrayList<>();
        for (WebElement product : productNames) {
            actualProductsName.add(product.getText());
        }
        List<String> expectedProductName = new ArrayList<>(actualProductsName);
        Collections.sort(expectedProductName);
        Assert.assertEquals("Product name is not displayed in alphabetical order",expectedProductName,actualProductsName);




    }
    @Test
    public void verifyTheSortByPriceFilter(){
        //Mouse Hover on the ‘Women’ Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));

        //Mouse Hover on the ‘Tops’
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        //Click on the ‘Jackets’
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select Sort By filter “Price”
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"));
        //Create the object of select class
        Select select = new Select(dropDown);
        //Select by visible text
        select.selectByVisibleText("Price");

        //Verify the product price displayed in Low to High
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));

        List<String> actualPrice = new ArrayList<>(); // add actual price in this list
        for (WebElement price : priceElements) {
            actualPrice.add(price.getText());
        }

        List<String> expectedPriceOrder = new ArrayList<>(actualPrice);
        Collections.sort(expectedPriceOrder);
        Assert.assertEquals("Price are not displayed in the low to high order",expectedPriceOrder,actualPrice);


    }

    @After
    public void tearDown() {
        //  closeBrowser();
    }
}
