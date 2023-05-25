package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage5ConfirmOrder extends PageBase{
    public CheckoutPage5ConfirmOrder(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.button-1.confirm-order-next-step-button")
    WebElement continueBtn;

    public void ConfirmOrder()
    {
        clickButton(continueBtn);
    }
}
