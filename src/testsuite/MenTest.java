package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){

        // click on consent
        clickOnElement(By.xpath("//p[normalize-space()='Consent']"));

        //Mouse Hover on the ‘Men’ Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Men']"));

        //Mouse Hover on the ‘Bottoms’
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));

        // Click on the ‘Pants’
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //Mouse Hover on the product name ‘Cronus Yoga Pant’ and click on the size 32
        mouseHoverToElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

        //Mouse Hover on the product name ‘Cronus Yoga Pant’ and click on the Color Black.
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        // Mouse Hover on the product 'Cronus Yoga Pant' and click on the Color
        WebElement colorOption = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        colorOption.click();

        //click on the 'Add To Cart' Button
        WebElement selectColor = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        selectColor.click();

        // Verify the message 'You added Cronus Yoga Pant to your shopping cart.'



    }


    @After
    public void tearDown() {
        //  closeBrowser();
    }
}
