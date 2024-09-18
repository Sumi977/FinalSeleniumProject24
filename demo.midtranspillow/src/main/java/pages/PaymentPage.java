package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    public static WebDriver driver;
    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//iframe[@id='snap-midtrans']")
    private WebElement iFrameElement;

    @FindBy(xpath = "//div[@class='list-title text-actionable-bold']")
    WebElement goPayLaterPmtMethod;

    @FindBy(xpath = "//span[normalize-space()='Virtual account']")
    WebElement virtualAccountPmtMethod;

    @FindBy(xpath = "//div[contains(text(),'Credit/debit card')]")
    WebElement creditDebitCardPmtMethod;

    @FindBy(xpath = "//div[@class='list-title text-actionable-bold']")
    WebElement shoppePayLaterPmtMethod;
    @FindBy(xpath = "//span[normalize-space()='Dana']")
    WebElement danaPaymentMethod;

    @FindBy(xpath = "//div/a/div/div[normalize-space()='Alfa Group']")
    WebElement alfaGroupPaymentMethod;

    @FindBy(xpath = "//div/a/div/div[normalize-space()='QRIS']")
    WebElement qrisPaymentMethod;

    @FindBy(xpath = "//div/a/div/div[normalize-space()='Indomaret']")
    WebElement indomaretPaymentMethod;

    @FindBy(xpath = "//span[normalize-space()='Akulaku PayLater']")
    WebElement akulakuPayLaterPaymentMethod;

    @FindBy(xpath = "//span[normalize-space()='Kredivo']")
    WebElement kredivoPaymentMethod;



    @FindBy(xpath = "//span[normalize-space()='Promo Flash Sale (Credit-Card)']")
    WebElement promoFlashSaleCouponCode;

    @FindBy(xpath = "//button[normalize-space()='Use']")
    WebElement useButtonForCoupon;

    @FindBy(xpath = "//td[normalize-space()='Rp19.000']")
    WebElement newTotalAmtAfterCouponCode;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement cardNumberTextbox;

    @FindBy(id = "card-expiry")
    WebElement expirationDateTextbox;

    @FindBy(id="card-cvv")
    WebElement cvvTextbox;

    @FindBy(xpath = "//div[@class='title-bar']")
    WebElement cardDetailScreen;

    @FindBy(xpath = "//div[@class='header-amount']")
    WebElement orderAmountOnCardDetailScreen;

    @FindBy(xpath = "//div[normalize-space()='Rp19.000']")
    WebElement orderAmountAfterApplyingCouponCode;

    @FindBy(xpath = "//div[@class='modal-iframe']")
    WebElement frame1;

    @FindBy(xpath = "//div[@class='close-snap-button clickable']")
    WebElement closeFrame1;

    @FindBy(xpath = "//button[@type='button']")
    WebElement payNowButton;

    @FindBy(xpath = "//button[@type='button']")
    WebElement backButtonOnOrderPayment;

    public void clickOnBackButtonToCancelOrder(){
        backButtonOnOrderPayment.click();
    }

    public void quitFrame1(){
        closeFrame1.click();


    }



    public void switchToFrame(){
        driver.switchTo().frame(iFrameElement);
    }

    public void switchToFrame1(){
        driver.switchTo().frame(frame1);
    }

    public void clickOnPayNowButton(){
        payNowButton.click();
    }




    public boolean checkIfGoPayLaterPmtMethodIsAvailable(){
        return goPayLaterPmtMethod.isDisplayed();
    }
    public boolean checkIfVirtualAccountPmtMethodIsAvailable(){
        return virtualAccountPmtMethod.isDisplayed();
    }
    public boolean checkIfCreditDebitCardPmtIsAvailable(){
        return creditDebitCardPmtMethod.isDisplayed();
    }
    public boolean checkIfShoppePayLaterPmtMethodIsAvailable(){
        return shoppePayLaterPmtMethod.isDisplayed();
    }

    public boolean checkIfDanaPaymentMethodIsAvailable(){
        return danaPaymentMethod.isDisplayed();
    }

    public boolean checkIfAlfaGroupPaymentMethodIsAvailable(){
        return alfaGroupPaymentMethod.isDisplayed();
    }
    public boolean checkIfQrisPaymentMethodIsAvailable(){
        return qrisPaymentMethod.isDisplayed();
    }
    public boolean checkIfIndomaretPaymentMethodIsAvailable(){
        return indomaretPaymentMethod.isDisplayed();
    }
    public boolean checkIfAkulakuPayLaterPaymentMethodIsAvailable(){
        return akulakuPayLaterPaymentMethod.isDisplayed();
    }
    public boolean checkIfKredivoPaymentMethodIsAvailable(){
        return kredivoPaymentMethod.isDisplayed();
    }

    public boolean checkIfUserRedirectedToCardDetailsScreen(){
        return cardDetailScreen.isDisplayed();
    }
    public boolean checkIfOrderAmountIsRp20000InCardDetailScreen(){
        return orderAmountOnCardDetailScreen.isDisplayed();
    }
    public boolean checkIfOrderAmountIsRp19000InCardDetailScreen(){
        return orderAmountAfterApplyingCouponCode.isDisplayed();
    }






    public void chooseCreditDebitCardPmtOption(){
        creditDebitCardPmtMethod.click();
    }





    public void selectPromoCouponCode(){
        promoFlashSaleCouponCode.click();
    }
    public void checkIfUseButtonIsClickable(){
        useButtonForCoupon.click();
    }
    public void enterValidCreditCardNumber(){
        cardNumberTextbox.sendKeys("4811111111111114");
    }
    public void enterValidExpiryDateOfCreditCard(){
        expirationDateTextbox.sendKeys("0225");
    }
    public void enterValidCvv(){
        cvvTextbox.sendKeys("123");
    }

}
