package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class UserRegisterationTest extends TestBase{
    HomePage homeObject;
    UserRegisterationPage registerObject;
    LoginPage loginObject;

    @Test(priority = 1)
    public void UserCanRegisterSuccessfuly()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject = new UserRegisterationPage(driver);
        registerObject.UserRegisteration("Abdulrahman",
                "Mohamed","abdos@gmail.com","123456789");
        Assert.assertTrue(registerObject.SuccessMessage.getText().contains("Your registration completed"));
    }
    @Test(priority = 2)
    public void RegisteredUserCanLogin()
    {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
            loginObject.UserLogin("abdos@gmail.com","123456789");
        Assert.assertTrue(registerObject
                .logoutLink.getText().contains("Log out"));
    }
}
