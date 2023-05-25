package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage3PaymentMethod extends PageBase{
    public CheckoutPage3PaymentMethod(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "paymentmethod_1")
    WebElement creCardRadioBtn;

    @FindBy(css = "button.button-1.payment-method-next-step-button")
    WebElement continueBtn;

    public void ChoosingPaymentMethod()
    {
        //clickButton(creCardRadioBtn);
        clickButton(continueBtn);
    }
}
