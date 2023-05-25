package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage2ShippingMethod extends PageBase{
    public CheckoutPage2ShippingMethod(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "shippingoption_1")
    WebElement dayAir1RadioBtn;

    @FindBy(css = "button.button-1.shipping-method-next-step-button")
    WebElement continueBTn;

    public void ChoosingShippingMethod()
    {
        clickButton(dayAir1RadioBtn);
        clickButton(continueBTn);
    }
}
