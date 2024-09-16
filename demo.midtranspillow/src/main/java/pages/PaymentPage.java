package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "snap-midtrans")
    private WebElement iFrameElement;

    @FindBy(xpath = "//div[@class='list-title text-actionable-bold']")
    WebElement goPayLaterPmtMethod;

    @FindBy(xpath = "//span[normalize-space()='Virtual account']")
    WebElement virtualAccountPmtMethod;

    @FindBy(xpath = "//div[contains(text(),'Credit/debit card')]")
    WebElement creditDebitCardPmtMethod;

    @FindBy(xpath = "//div[@class='list-title text-actionable-bold']")
    WebElement shoppePayLaterPmtMethod;

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



    public void switchToFrame(){
        driver.switchTo().frame(iFrameElement);
    }




    public boolean checkIfGoPayLaterPmtMethodIsAvailable(){
        return goPayLaterPmtMethod.isDisplayed();
    }
    public boolean checkIfvirtualAccountPmtMethodIsAvailable(){
        return virtualAccountPmtMethod.isDisplayed();
    }
    public boolean checkIfCreditDebitCardPmtIsAvailable(){
        return creditDebitCardPmtMethod.isDisplayed();
    }
    public boolean checkIfShoppePayLaterPmtMethodIsAvailable(){
        return shoppePayLaterPmtMethod.isDisplayed();
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
        cardNumberTextbox.sendKeys();
    }
    public void enterValidExpiryDateOfCreditCard(){
        expirationDateTextbox.sendKeys();
    }
    public void enterValidCvv(){
        cvvTextbox.sendKeys();
    }

}
