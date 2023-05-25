package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    WebElement fullNameText;

    @FindBy(id = "Email")
    WebElement emailText;

    @FindBy(id = "Enquiry")
    WebElement enquiryText;

    @FindBy(name = "send-email")
    WebElement submitBtn;

    @FindBy(css = "div.result")
    public WebElement succesMessage;

    public void ContactUs(String fullName, String email, String message)
    {
        setTextElementText(fullNameText,fullName);
        setTextElementText(emailText,email);
        setTextElementText(enquiryText,message);
        clickButton(submitBtn);
    }

}
