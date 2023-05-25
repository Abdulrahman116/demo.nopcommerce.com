package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(css = "button.button-1.login-button")
    WebElement loginBtn;

    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    public void UserLogin(String email, String Password)
    {
        setTextElementText(emailTxtBox, email);
        setTextElementText(passwordTxtBox,Password);
        clickButton(loginBtn);
    }

    public void openMyAccountPage()
    {
        clickButton(myAccountLink);
    }
}
