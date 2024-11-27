package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //Mouse Hover on the ‘Gear’Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));

        //Click on the ‘Bags’
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));

        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        //Change the Qty 3
        driver.findElement(By.id("qty")).clear();
        sendTextToElement(By.id("qty"), "3");

        //Click on the ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));

        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedMessage = "You added Overnight Duffle to your shopping cart.";
        String actualMessage = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals("You added Overnight Duffle to your shopping cart message not displayed",expectedMessage,actualMessage);

        // Click on the ‘shopping cart’ Link into  message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));


        // Verify the product name ‘Overnight Duffle’ in the cart
        WebElement cartProductName = driver.findElement(By.xpath("//td[@class='col product']//a"));
        Assert.assertTrue("Product name in cart is incorrect", cartProductName.getText().contains("Overnight Duffle"));


        //Verify the Qty is ‘3’
        WebElement cartQty = driver.findElement(By.xpath("//input[@title='Qty']"));
        Assert.assertEquals("Quantity in cart is incorrect", "3", cartQty.getAttribute("value"));

        // Verify the product price ‘$135.00’
        WebElement productPrice = driver.findElement(By.xpath("//span[@class='price'][contains(text(),'$135.00')]"));
        Assert.assertTrue("Product price is incorrect", productPrice.getText().contains("$135.00"));




    }



    @After
    public void tearDown() {
         closeBrowser();
    }

}
