package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public static WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[normalize-space()='BUY NOW']")
    WebElement buyNowButton;

    @FindBy(xpath = "//td[@class='amount']")
    WebElement midtransPillowAddedInCart;

    @FindBy(xpath = "//input[@value='20000']")
    WebElement priceOfPillow;

    @FindBy(xpath = "//div[normalize-space()='CHECKOUT']")
    WebElement checkoutPopup;
    @FindBy(xpath = "//input[@value='Budi']")
    WebElement nameTextbox;
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailTextbox;

    @FindBy(xpath = "//input[@value='081808466410']")
    WebElement phoneTextbox;

    @FindBy(xpath = "//input[@value='Jakarta']")
    WebElement cityTextbox;

    @FindBy(xpath = "//textarea[normalize-space()='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']")
    WebElement addressTextbox;
    @FindBy(xpath = "//input[@value='10220']")
    WebElement postalCodeTextbox;
    @FindBy(xpath = "//div[normalize-space()='CHECKOUT']")
    WebElement checkoutButton;


    @FindBy(xpath = "//iframe[@id='snap-midtrans']")
    WebElement iFrame;



    public void clickOnBuyNowButton(){
        buyNowButton.click();
    }
    public boolean checkIfPriceOfPillowIs20000(){
       return priceOfPillow.isDisplayed();
    }
    public boolean checkIfMidtransPillowHasAddedInCart(){
        return midtransPillowAddedInCart.isDisplayed();
    }
    public boolean checkIfCheckoutPopupVisible(){
        return checkoutPopup.isDisplayed();
    }
    public void checkIfNameTextBoxIsEditable(){
        nameTextbox.sendKeys("Abcxyz");
    }
    public void checkIfEmailTextboxIsEditable(){
        emailTextbox.sendKeys("xyz1234@yahoo.com");
    }
    public void checkIfPhoneTextboxIsEditable(){
        phoneTextbox.sendKeys("12346789");
    }
    public void checkIfCityTextboxIsEditable(){
        cityTextbox.sendKeys("Florida");
    }
    public void checkIfAddressTextboxIsEditable(){
        addressTextbox.sendKeys("Newyork 41-22,1st Floor");
    }
    public void checkIfPostalCodeTextboxIsEditable(){
        postalCodeTextbox.sendKeys("112233");
    }
    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public boolean checkIfNameTextBoxIsVisible(){
        return nameTextbox.isDisplayed();
    }
    public boolean checkIfEmailTextBoxIsVisible(){
        return emailTextbox.isDisplayed();

    }
    public boolean checkIfPhoneTextBoxIsVisible() {
        return phoneTextbox.isDisplayed();
    }
    public boolean checkIfCityTextBoxIsVisible() {
        return cityTextbox.isDisplayed();

    }
    public boolean checkIfAddressTextBoxIsVisible() {
        return addressTextbox.isDisplayed();
    }
    public boolean checkIfPostalCodeTextBoxIsVisible() {
       return  postalCodeTextbox.isDisplayed();
    }

    public void switchBackToDefaultPage(){
        driver.switchTo().defaultContent();}
}
