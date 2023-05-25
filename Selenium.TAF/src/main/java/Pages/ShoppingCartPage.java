package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement appleDevice;
    @FindBy(name = "updatecart")
    WebElement removeBtn;
    @FindBy(css = "input.qty-input")
    WebElement changeQuantityTxtBox;
    @FindBy(id = "updatecart")
    WebElement updateCartBtn;
    @FindBy(css = "div.no-data")
    public WebElement cartEmptyMessage;
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;
    @FindBy(id = "termsofservice")
    public WebElement termsBtn;

    public void ChangeAppleDeviceQuantity(String quantity)
    {
        //clickButton(changeQuantityTxtBox);
        changeQuantityTxtBox.clear();
        setTextElementText(changeQuantityTxtBox,quantity);
        clickButton(updateCartBtn);
    }

    public void RemoveDeviceFromCart()
    {
        clickButton(removeBtn);
    }

    public void ClickOnCheckoutAndTermsBtn()
    {
        clickButton(termsBtn);
        clickButton(checkoutBtn);
    }
}
