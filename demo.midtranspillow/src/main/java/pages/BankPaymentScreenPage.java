package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankPaymentScreenPage {
    public static WebDriver driver;

    public BankPaymentScreenPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div/label[normalize-space()='Merchant Name:']")
    WebElement merchantNameOnBankPaymentScreenPage;

    @FindBy(xpath = "//div/label[normalize-space()='Amount:']")
    WebElement amountOnBankPaymentScreenPage;

    @FindBy(xpath = "//label[normalize-space()='Transaction Time:']")
    WebElement transactionTimeOnBankPaymentPage;

    @FindBy(xpath = "//label[normalize-space()='Card Number:']")
    WebElement cardNumberOnBankPaymentPage;


    @FindBy(xpath = "//label[normalize-space()='Password:']")
    private WebElement passwordOnBankPaymentPage;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okOnBankPaymentPage;

    @FindBy(xpath = "//h1[normalize-space()='Issuing Bank']")
    WebElement bankPaymentScreen;

    @FindBy(xpath = "//iframe[@title='3ds-iframe']")
    WebElement bankPaymentScreenIFrame;


    @FindBy(xpath = "//button[@name='cancel']")
    WebElement cancelButtonOnBankPaymentScreen;

    @FindBy(xpath = "//input[@id='otp']")
    WebElement passwordTextboxOnBankPaymentScreen;

//    @FindBy(xpath = "//div[@class='trans-status trans-success']")
//    WebElement orderSuccessFullScreen;

    @FindBy(xpath = "//div[@class='trans-status trans-success']")
    WebElement thankYouForYourPurchaseScreen;

    @FindBy(xpath = "//div[normalize-space()='Payment declined by bank']")
    WebElement paymentDeclinedByBank;

    @FindBy(xpath = "//button[normalize-space()='Back']")
    WebElement backButton;

    public void clickOnBackButton(){
        backButton.click();
    }

    @FindBy(xpath = "//div[@class='trans-status trans-error']")
    WebElement orderFailedScreen;

    @FindBy(xpath = "//iframe[@id='snap-midtrans']")
    WebElement backButtonIFrame;

    @FindBy(xpath = "//div[@class='prompt-modal-subtitle']")
    WebElement paymentDeclinedByBankScreen;//

    public void switchToBackButtonIFrame(){
        driver.switchTo().frame(backButtonIFrame);
    }

    public boolean checkIfUserRedirectToOrderFailedScreen(){
        return orderFailedScreen.isDisplayed();
    }


    public boolean checkIfPaymentDeclinedByBankScreenIsVisible(){
        return paymentDeclinedByBank.isDisplayed();
    }

    public void enterPasswordOnBankPaymentScreen(){
        passwordTextboxOnBankPaymentScreen.sendKeys("112233");
    }

    public void enterWrongpasswordForIssuingBankPage(){
        passwordTextboxOnBankPaymentScreen.sendKeys("123456");
    }
    public void clickCancelButtonOnBankPaymentScreen(){
        cancelButtonOnBankPaymentScreen.click();
    }

    public void switchToBankPaymentScreenIFrame(){
        driver.switchTo().frame(bankPaymentScreenIFrame);

    }
    public void switchFromBankPaymentScreen(){
        driver.switchTo().defaultContent();
    }

    public boolean checkIfBankPaymentScreenIsVisible(){
        return bankPaymentScreen.isDisplayed();
    }

    public boolean checkIfMerchantNameOnBankPaymentScreenPageIsVisible(){
        return merchantNameOnBankPaymentScreenPage.isDisplayed();

    }
    public boolean checkIfAmountOnBankPaymentScreenPageIsVisible(){
        return amountOnBankPaymentScreenPage.isDisplayed();

    }
    public boolean checkIfTransactionTimeOnBankPaymentScreenPageIsVisible(){
        return transactionTimeOnBankPaymentPage.isDisplayed();

    }
    public boolean checkIfCardNumberOnBankPaymentScreenPageIsVisible(){
        return cardNumberOnBankPaymentPage.isDisplayed();

    }
    public boolean checkIfPasswordOnBankPaymentScreenPageIsVisible(){
        return passwordOnBankPaymentPage.isDisplayed();

    }
    public void clickOnOkButtonOnBankPaymentPage(){
        okOnBankPaymentPage.click();
    }
    public boolean checkIfThankYouForYourPurchaseTextIsVisible(){
        return thankYouForYourPurchaseScreen.isDisplayed();

    }

}

