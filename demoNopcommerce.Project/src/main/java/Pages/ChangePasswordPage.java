package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase{
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxtBox;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxtBox;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordTxtBox;

    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePasswordBtn;

    @FindBy(css = "p.content")
    public WebElement changePasswordSuccessed;

    @FindBy(linkText = "My account")
    WebElement myaccountLinkTxt;

    @FindBy(linkText = "Change password")
    WebElement changePasswordLinkTxt;


    public void changePassword(String oldPassword,String newPassword)
    {
        clickButton(myaccountLinkTxt);
        clickButton(changePasswordLinkTxt);
        setTextElementText(oldPasswordTxtBox,oldPassword);
        setTextElementText(newPasswordTxtBox,newPassword);
        setTextElementText(confirmNewPasswordTxtBox,newPassword);
        clickButton(changePasswordBtn);
    }
}
