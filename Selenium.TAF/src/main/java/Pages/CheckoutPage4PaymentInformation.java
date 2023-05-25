package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage4PaymentInformation extends PageBase{
    public CheckoutPage4PaymentInformation(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.button-1.payment-info-next-step-button")
    WebElement continueBtn;

    public void ConfirmPaymentInformation()
    {
        clickButton(continueBtn);
    }
}
