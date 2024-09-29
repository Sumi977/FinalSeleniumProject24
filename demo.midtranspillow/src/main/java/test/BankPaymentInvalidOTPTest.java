package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import setup.DriverFactory;
import setup.Util;

public class BankPaymentInvalidOTPTest {
    WebDriver driver;
    BasePage basePage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    OrderSummaryPage orderSummaryPage;
    PaymentPage paymentPage;
    BankPaymentScreenPage bankPaymentScreenPage;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.getDriver(Util.getProperties("browserName"));
        basePage = new BasePage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage = new HomePage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        paymentPage = new PaymentPage(driver);
        bankPaymentScreenPage = new BankPaymentScreenPage(driver);
        basePage.launchApplication(Util.getProperties("url"));
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(homePage.checkIfCocoTextDisplayedOnLeftHeader());
        checkoutPage.clickOnBuyNowButton();
        Util.pauseExecutionForSeconds(2);
        checkoutPage.clickOnCheckoutButton();
        Util.pauseExecutionForSeconds(2);
        orderSummaryPage.switchToIFrame();
        Util.pauseExecutionForSeconds(2);
        paymentPage.chooseCreditDebitCardPmtOption();
        Util.pauseExecutionForSeconds(2);
        paymentPage.enterValidCreditCardNumber();
        Util.pauseExecutionForSeconds(2);
        paymentPage.enterValidExpiryDateOfCreditCard();
        Util.pauseExecutionForSeconds(2);
        paymentPage.enterValidCvv();
        Util.pauseExecutionForSeconds(2);
        paymentPage.selectPromoCouponCode();
        Util.pauseExecutionForSeconds(2);
        paymentPage.clickOnPayNowButton();
        Util.pauseExecutionForSeconds(2);
        bankPaymentScreenPage.switchToBankPaymentScreenIFrame();
    }
    // Test case 14
    @Test
    public void verifyEnteringWrongOTPShouldRedirectUserToPaymentDeclinedScreen(){
        Util.pauseExecutionForSeconds(2);
        bankPaymentScreenPage.enterWrongpasswordForIssuingBankPage();
        Util.pauseExecutionForSeconds(2);
        bankPaymentScreenPage.clickOnOkButtonOnBankPaymentPage();
        Util.pauseExecutionForSeconds(2);
        driver.switchTo().frame(0);
        Util.pauseExecutionForSeconds(2);
        bankPaymentScreenPage.clickOnBackButton();
        Util.pauseExecutionForSeconds(2);
        driver.switchTo().defaultContent();
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(bankPaymentScreenPage.checkIfUserRedirectToOrderFailedScreen());

    }



    @AfterClass(alwaysRun = true)
    public void tearDown(){
        basePage.closeBrowser();
    }
}











