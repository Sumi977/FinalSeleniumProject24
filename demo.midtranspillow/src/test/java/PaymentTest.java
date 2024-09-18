import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import setup.DriverFactory;
import setup.Util;

public class PaymentTest {
    WebDriver driver;
    CheckoutPage checkoutPage;
    BasePage basePage;
    HomePage homepage;
    OrderSummaryPage orderSummaryPage;
    PaymentPage paymentPage;

    @BeforeClass
    public void tearUp(){
        driver = DriverFactory.getDriver(Util.getProperties("browserName"));
        basePage = new BasePage(driver);
        checkoutPage = new CheckoutPage(driver);
        homepage = new HomePage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        paymentPage = new PaymentPage(driver);
        basePage.launchApplication(Util.getProperties("url"));
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(homepage.checkIfCocoTextDisplayedOnLeftHeader());

    }
    // Test case 7 & 8
    @Test(priority = 1)
    public void verifyAllPaymentOptionsOnPaymentPage(){
        checkoutPage.clickOnBuyNowButton();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.clickOnCheckoutButton();
        Util.pauseExecutionForSeconds(2);
        orderSummaryPage.switchToIFrame();
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(paymentPage.checkIfGoPayLaterPmtMethodIsAvailable());
        Assert.assertTrue(paymentPage.checkIfVirtualAccountPmtMethodIsAvailable());
        Assert.assertTrue(paymentPage.checkIfCreditDebitCardPmtIsAvailable());
        Assert.assertTrue(paymentPage.checkIfShoppePayLaterPmtMethodIsAvailable());
        Assert.assertTrue(paymentPage.checkIfDanaPaymentMethodIsAvailable());
        Assert.assertTrue(paymentPage.checkIfQrisPaymentMethodIsAvailable());
        Assert.assertTrue(paymentPage.checkIfAlfaGroupPaymentMethodIsAvailable());
        Assert.assertTrue(paymentPage.checkIfIndomaretPaymentMethodIsAvailable());
        Assert.assertTrue(paymentPage.checkIfAkulakuPayLaterPaymentMethodIsAvailable());
        Assert.assertTrue(paymentPage.checkIfKredivoPaymentMethodIsAvailable());
        Util.pauseExecutionForSeconds(2);
        
        orderSummaryPage.closeIFramePopup();

        orderSummaryPage.switchBackToDefaultPage();
    }
    // Test case 9
    @Test(priority = 2)
    public void verifyUserCanClickOnCreditDebitCardPmtMethodAndRedirectedToCardDetailsScreen() {
        checkoutPage.clickOnBuyNowButton();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.clickOnCheckoutButton();
        Util.pauseExecutionForSeconds(2);
        orderSummaryPage.switchToIFrame();
        paymentPage.chooseCreditDebitCardPmtOption();
        Assert.assertTrue(paymentPage.checkIfUserRedirectedToCardDetailsScreen());
        orderSummaryPage.closeIFramePopup();        
                                                    
        orderSummaryPage.switchBackToDefaultPage(); 




    }

   @Test(priority = 3)
   public void verifyOrderAmountOnCardDetailsScreenBeforeCouponCode(){
        checkoutPage.clickOnBuyNowButton();
        checkoutPage.clickOnCheckoutButton();
        orderSummaryPage.switchToIFrame();
        paymentPage.chooseCreditDebitCardPmtOption();

        paymentPage.enterValidCreditCardNumber();
        Util.pauseExecutionForSeconds(2);
        paymentPage.enterValidExpiryDateOfCreditCard();
        Util.pauseExecutionForSeconds(2);
        paymentPage.enterValidCvv();







   }



    @AfterClass
    public void tearDown(){
        basePage.closeBrowser();
    }
}
