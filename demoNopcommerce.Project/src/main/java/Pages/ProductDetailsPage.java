package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productNameLinkTxt;


    public void productDetailsSuccess()
    {
        clickButton(productNameLinkTxt);
    }
}
