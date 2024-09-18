package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public static WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[normalize-space()='Coco']")
    WebElement cocoTextOnLeftHeader;


    public boolean checkIfCocoTextDisplayedOnLeftHeader(){
        return cocoTextOnLeftHeader.isDisplayed();

    }
}
