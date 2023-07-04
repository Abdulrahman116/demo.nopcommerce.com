package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerLinkTxt;
    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;
    @FindBy(linkText = "Log out")
    WebElement logoutLinkTxt;



    public void clickOnRegisterLinkTxt()
    {
        clickButton(registerLinkTxt);
    }
    public void searchProduct(String product)
    {
        setTextElementText(searchTxtBox, product);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(searchBtn);
    }
    public void clickOnlogoutLinkTxt()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(logoutLinkTxt);
    }
}
