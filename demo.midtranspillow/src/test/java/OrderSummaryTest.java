import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderSummaryPage;
import setUp.DriverFactory;
import setUp.Util;

public class OrderSummaryTest {
    WebDriver driver;
    BasePage basePage;
    HomePage homePage;
    CheckoutPage checkoutPage;
    OrderSummaryPage orderSummaryPage;
    @BeforeClass
    public void setUp(){
        driver= DriverFactory.getDriver(Util.getProperties("browserName"));
        basePage =new BasePage(driver);
        homePage = new HomePage(driver);
        checkoutPage =new CheckoutPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        basePage.launchApplication(Util.getProperties("url"));
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(homePage.checkIfCocoTextDisplayedOnLeftHeader());
    }
    @Test
    public void verifyCheckoutButtonRedirectToOrderSummaryPage(){
        checkoutPage.clickOnBuyNowButton();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.checkIfCheckoutButtonIsClickable();
        Util.pauseExecutionForSeconds(2);
        orderSummaryPage.switchToIFrame();
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(orderSummaryPage.checkIfOrderSummaryIFramePopUp());
    }
    @Test
    public void verifyProductNameAndPriceOnOrderSummaryPage(){
        checkoutPage.clickOnBuyNowButton();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.checkIfCheckoutButtonIsClickable();
        Util.pauseExecutionForSeconds(2);
        orderSummaryPage.switchToIFrame();
        Util.pauseExecutionForSeconds(2);
        orderSummaryPage.clickOnDetailsOnOrderSummaryIFrame();

        Assert.assertTrue(orderSummaryPage.checkIfProductNameIsCorrectInSummaryPopup());
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(orderSummaryPage.checkIfPriceIsCorrectInSummqaryPopup());


    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        basePage.closeBrowser();
    }
}
