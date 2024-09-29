import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
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

    @BeforeClass(alwaysRun = true)
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
    // Test case 12
    @Test(priority = 1)
    public void verifyAfterClickingPayNowButtonUserRedirectToBankPaymentScreenAndDetails(){

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


    }
    // Test case 13
    @Test(priority = 2)
    public void verifyClickingOnOKButtonRedirectUserToOrderSuccessfullScreen(){

        Util.pauseExecutionForSeconds(2);
        bankPaymentScreenPage.enterPasswordOnBankPaymentScreen();
        Util.pauseExecutionForSeconds(2);
        bankPaymentScreenPage.clickOnOkButtonOnBankPaymentPage();
        Util.pauseExecutionForSeconds(2);
        driver.switchTo().defaultContent();
        Assert.assertTrue(bankPaymentScreenPage.checkIfThankYouForYourPurchaseTextIsVisible());
    }



    @AfterClass(alwaysRun = true)
    public void tearDown(){
        basePage.closeBrowser();
    }
}
