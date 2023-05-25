package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisterationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase{

    HomePage homeObject;
    UserRegisterationPage registerObject;
    LoginPage loginObject;
    MyAccountPage myAccountObject;
    String oldPassword = "123456789";
    String newPassword = "987654321";
    String firstName = "Abdulrahman";
    String lastName = "Magdy";
    String email = "abdomagdy678@gmail.com";

    //Registeration
    @Test(priority = 1)
    public void UserCanRegisterSuccessfuly()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject = new UserRegisterationPage(driver);
        registerObject.UserRegisteration(firstName,
                lastName,email,oldPassword);
        Assert.assertTrue(registerObject.SuccessMessage.getText().contains("Your registration completed"));
    }
    //Login
    @Test(priority = 2)
    public void RegisteredUserCanLogin()
    {

        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,oldPassword);
        Assert.assertTrue(registerObject
                .logoutLink.getText().contains("Log out"));
    }
    //Change password
    @Test(priority = 3)
    public void RegisteredUserCanChangePassword()
    {
        myAccountObject = new MyAccountPage(driver);
        loginObject = new LoginPage(driver);
        loginObject.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.ChangePassword(oldPassword,newPassword);
        Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
        myAccountObject.ClickOnCustInfoText();
    }

    @Test(priority = 4)
    public void RegisteredUserCanLoginAgain()
    {

        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,newPassword);
        Assert.assertTrue(registerObject
                .logoutLink.getText().contains("Log out"));
    }

    @Test(priority = 5)
    public void UserCanLogout()
    {
        registerObject = new UserRegisterationPage(driver);
        registerObject.UserCanLogout();
    }
}
