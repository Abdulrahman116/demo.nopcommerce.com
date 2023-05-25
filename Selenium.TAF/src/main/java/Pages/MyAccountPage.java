package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordText;

    @FindBy(id = "NewPassword")
    WebElement newPasswordText;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordText;

    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePasswordBtn;

    @FindBy(css = "p.content")
    public WebElement resultLbl;

    @FindBy(linkText = "Customer info")
    public WebElement custInfoText;

    public void openChangePasswordPage()
    {
        clickButton(changePasswordLink);
    }

    public void ChangePassword(String oldPassword, String newPassword)
    {

        setTextElementText(oldPasswordText,oldPassword);
        setTextElementText(newPasswordText,newPassword);
        setTextElementText(confirmNewPasswordText,newPassword);
        clickButton(changePasswordBtn);
    }

    public void ClickOnCustInfoText()
    {
        clickButton(custInfoText);
    }
}
