package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
    public static WebDriver driver;

    public OrderSummaryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//iframe[@id='snap-midtrans']")
    WebElement iFrame;

    @FindBy(xpath ="//div[@class='title-bar']" )
    WebElement orderSummaryIFramePopup;
    @FindBy(xpath = "//span[normalize-space()='Midtrans Pillow']")
    WebElement productNameOnSummaryPopup;
    @FindBy(xpath = "//td[@class='table-amount text-body order-summary-bold']")
    WebElement priceOfProductOnSummaryPopup;
    @FindBy(xpath = "//span[normalize-space()='Details']")
    WebElement detailsOnOrderSummaryPage;
    @FindBy(xpath = "//div[@class='close-snap-button clickable']")
    WebElement closeIFramePopupElement;

    public boolean checkIfOrderSummaryIFramePopUp(){
       return orderSummaryIFramePopup.isDisplayed();
    }
    public boolean checkIfProductNameIsCorrectInSummaryPopup(){
        return productNameOnSummaryPopup.isDisplayed();
    }
    public boolean checkIfPriceIsCorrectInSummaryPopup(){
        return priceOfProductOnSummaryPopup.isDisplayed();
    }
    public void switchToIFrame(){
        driver.switchTo().frame(iFrame);
    }
    public void clickOnDetailsOnOrderSummaryIFrame(){
        detailsOnOrderSummaryPage.click();
    }
    public void switchBackToDefaultPage(){
        driver.switchTo().defaultContent();
    }
    public void closeIFramePopup(){
        closeIFramePopupElement.click();
    }

}
