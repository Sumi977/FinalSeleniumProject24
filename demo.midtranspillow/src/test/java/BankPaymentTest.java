import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import setup.DriverFactory;
import setup.Util;

public class BankPaymentTest {
    WebDriver driver;
    BasePage basePage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    OrderSummaryPage orderSummaryPage;
    PaymentPage paymentPage;
    BankPaymentScreenPage bankPaymentScreenPage;

    @BeforeClass
    public void setUp(){
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

    }
    @Test
    public void verifyAfterClickingPayNowButtonUserRedirectToBankPaymentScreenAndDetails(){
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
        Util.pauseExecutionForSeconds(2);
        bankPaymentScreenPage.checkIfBankPaymentScreenIsVisible();
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(bankPaymentScreenPage.checkIfMerchantNameOnBankPaymentScreenPageIsVisible());
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(bankPaymentScreenPage.checkIfAmountOnBankPaymentScreenPageIsVisible());
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(bankPaymentScreenPage.checkIfAmountOnBankPaymentScreenPageIsVisible());
        Util.pauseExecutionForSeconds(2);
        Assert.assertTrue(bankPaymentScreenPage.checkIfTransactionTimeOnBankPaymentScreenPageIsVisible());
        Assert.assertTrue(bankPaymentScreenPage.checkIfCardNumberOnBankPaymentScreenPageIsVisible());
        Util.pauseExecutionForSeconds(2);
        bankPaymentScreenPage.clickCancelButtonOnBankPaymentScreen();
        Util.pauseExecutionForSeconds(2);
        //paymentPage.clickOnBackButtonToCancelOrder();
        orderSummaryPage.switchBackToDefaultPage();



        //orderSummaryPage.switchBackToDefaultPage();
        //homePage.refreshHomePageByClickingOnCocoHeader();
        //bankPaymentScreenPage.switchFromBankPaymentScreen();
        //paymentPage.clickOnBackButtonToCancelOrder();




    }
    @Test
    public void verifyClickingOnOKButtonRedirectUserToOrderSuccessfullScreen(){
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
        Util.pauseExecutionForSeconds(2);
        bankPaymentScreenPage.clickOnOkButtonOnBankPaymentPage();


    }





    @AfterClass
    public void tearDown(){
        basePage.closeBrowser();
    }
}
