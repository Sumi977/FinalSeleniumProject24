package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CheckoutPage;
import pages.HomePage;
import setup.DriverFactory;
import setup.Util;


public class CheckoutTest {
    WebDriver driver;
    CheckoutPage checkoutPage;
    BasePage basePage;
    HomePage homePage;


    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverFactory.getDriver(Util.getProperties("browserName"));
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
        basePage.launchApplication(Util.getProperties("url"));
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(homePage.checkIfCocoTextDisplayedOnLeftHeader());


    }
    @Test(priority = 1)//Test case 1 & 2
    public void verifyIfMidtransPillowsAddedToCart() {
        checkoutPage.clickOnBuyNowButton();
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(checkoutPage.checkIfMidtransPillowHasAddedInCart());
        boolean actualValue = checkoutPage.checkIfPriceOfPillowIs20000();
        Assert.assertTrue(actualValue,"20000");
        Util.pauseExecutionForSeconds(2);
    }
    @Test(priority = 2) //Test case 3
    public void verifyNameEmailPhoneCityAddressPostalCodeInCheckoutPage(){
        Assert.assertTrue(checkoutPage.checkIfNameTextBoxIsVisible());
        Assert.assertTrue(checkoutPage.checkIfEmailTextBoxIsVisible());
        Assert.assertTrue(checkoutPage.checkIfPhoneTextBoxIsVisible());
        Assert.assertTrue(checkoutPage.checkIfCityTextBoxIsVisible());
        Assert.assertTrue(checkoutPage.checkIfAddressTextBoxIsVisible());
        Assert.assertTrue(checkoutPage.checkIfPostalCodeTextBoxIsVisible());

    }

    @Test(priority = 3) // Test case 4
    public void verifyNameEmailPhoneCityAddressPostalCodeInCheckoutPageIsEditable(){

        checkoutPage.checkIfNameTextBoxIsEditable();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.checkIfEmailTextboxIsEditable();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.checkIfPhoneTextboxIsEditable();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.checkIfCityTextboxIsEditable();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.checkIfAddressTextboxIsEditable();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.checkIfPostalCodeTextboxIsEditable();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.clickOnCheckoutButton();
        Util.pauseExecutionForSeconds(2);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        basePage.closeBrowser();
    }
}
