package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutProductPage extends PageBase{
    public CheckoutProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "termsofservice")
    WebElement termsCheckbox;
    @FindBy(id = "checkout")
    WebElement checkoutBtn;
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement selectCountry;
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement selectState;
    @FindBy(id = "BillingNewAddress_City")
    WebElement enterCity;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement enterAddress;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement enterZipCode;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement enterPhoneNumber;
    @FindBy(name = "save")
    WebElement continueBtn1;
    @FindBy(id = "shippingoption_1")
    WebElement shippingOption;
    @FindBy(css = "button.button-1.shipping-method-next-step-button")
    WebElement continueBtn2;
    @FindBy(css = "button.button-1.payment-method-next-step-button")
    WebElement continueBtn3;
    @FindBy(css = "button.button-1.payment-info-next-step-button")
    WebElement continueBtn4;
    @FindBy(css = "button.button-1.confirm-order-next-step-button")
    WebElement confirmOrderBtn;
    @FindBy(css = "button.button-1.order-completed-continue-button")
    WebElement continueBtn5;
    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailsLinkTxt;
    @FindBy(linkText = "PDF Invoice")
    WebElement InvoicePdfBtn;
    @FindBy(linkText = "Print")
    WebElement PrintBtn;




    public void addProductToCheckout
            (String city, String address, String zipCode, String phoneNumber)
    {
        clickButton(termsCheckbox);
        clickButton(checkoutBtn);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        select = new Select(selectCountry);
        select.selectByIndex(1);
        setTextElementText(enterCity,city);
        setTextElementText(enterAddress,address);
        setTextElementText(enterZipCode,zipCode);
        setTextElementText(enterPhoneNumber,phoneNumber);
        select = new Select(selectState);
        select.selectByIndex(1);
        clickButton(continueBtn1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(shippingOption);
        clickButton(continueBtn2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(continueBtn3);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(continueBtn4);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(confirmOrderBtn); // This is before the invoice directly
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(continueBtn5);
    }
    public void addProductToCheckoutPrintAndDownloadInvoice
            (String city, String address, String zipCode, String phoneNumber)
    {
        clickButton(termsCheckbox);
        clickButton(checkoutBtn);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        select = new Select(selectCountry);
        select.selectByIndex(1);
        setTextElementText(enterCity,city);
        setTextElementText(enterAddress,address);
        setTextElementText(enterZipCode,zipCode);
        setTextElementText(enterPhoneNumber,phoneNumber);
        select = new Select(selectState);
        select.selectByIndex(1);
        clickButton(continueBtn1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(shippingOption);
        clickButton(continueBtn2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(continueBtn3);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(continueBtn4);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(confirmOrderBtn); // This is before the invoice directly
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(orderDetailsLinkTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(InvoicePdfBtn);
        clickButton(PrintBtn);
    }
}
