package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

    public UserRegisterationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderRdoBtn;
    @FindBy(id = "FirstName")
    WebElement FNtextBox;
    @FindBy(id = "LastName")
    WebElement LNtextBox;
    @FindBy(id = "Email")
    WebElement emailTextBox;
    @FindBy(id = "Password")
    WebElement passTextBox;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassTextBox;
    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(css = "div.result")
    public WebElement SuccessMessage;

    @FindBy(linkText = "Log out")
    public WebElement logoutLink;


    public void UserRegisteration(String FirstName,String LastName, String Email,String Password)
    {
        clickButton(genderRdoBtn);
        setTextElementText(FNtextBox,FirstName);
        setTextElementText(LNtextBox,LastName);
        setTextElementText(emailTextBox,Email);
        setTextElementText(passTextBox,Password);
        setTextElementText(confirmPassTextBox,Password);
        clickButton(registerBtn);
    }

    public void UserCanLogout()
    {
        clickButton(logoutLink);
    }


}
