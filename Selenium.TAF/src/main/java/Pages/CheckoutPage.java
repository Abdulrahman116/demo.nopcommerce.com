package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement selectCountryList;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement selectStateList;

    @FindBy(id = "BillingNewAddress_City")
    WebElement cityTxtBox;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressTxtBox;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCodeTxtBox;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberTxtBox;

    @FindBy(name = "save")
    WebElement continueBtn;

    public void FillingBillingAddress(String city,String Address1,
                                      String zipCode, String phoneNumber)
    {
        select = new Select(selectCountryList);
        select.selectByIndex(1);
        setTextElementText(cityTxtBox, city);
        setTextElementText(addressTxtBox, Address1);
        setTextElementText(zipCodeTxtBox, zipCode);
        setTextElementText(phoneNumberTxtBox, phoneNumber);
        select = new Select(selectStateList);
        select.selectByIndex(1);
        clickButton(continueBtn);

    }
}
