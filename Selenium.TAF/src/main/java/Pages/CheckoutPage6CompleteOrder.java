package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage6CompleteOrder extends PageBase{
    public CheckoutPage6CompleteOrder(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.title")
    public WebElement orderSuccessfulyProcessed;

    @FindBy(css = "button.button-1.order-completed-continue-button")
    WebElement continueBtn;

    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailsLinkTxt;

    public void CompleteOrder()
    {
        clickButton(continueBtn);
    }

    public void GoToOrderDetails()
    {
        clickButton(orderDetailsLinkTxt);
    }
}
