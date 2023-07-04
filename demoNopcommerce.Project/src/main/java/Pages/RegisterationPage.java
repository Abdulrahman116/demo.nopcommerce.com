package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends PageBase{
    public RegisterationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement maleRadBtn;

    @FindBy(id = "FirstName")
    WebElement fNameTxtBox;

    @FindBy(id = "LastName")
    WebElement lNameTxtBox;

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtBox;


    @FindBy(id = "register-button")
    WebElement registerationBtn;

    @FindBy(linkText = "Log in")
    WebElement loginLinkTxt;

    public void userRegisteration(String fName,String lName,String email,String password)
    {
        clickButton(maleRadBtn);
        setTextElementText(fNameTxtBox,fName);
        setTextElementText(lNameTxtBox,lName);
        setTextElementText(emailTxtBox,email);
        setTextElementText(passwordTxtBox,password);
        setTextElementText(confirmPasswordTxtBox,password);
        clickButton(registerationBtn);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(loginLinkTxt);
    }

}
