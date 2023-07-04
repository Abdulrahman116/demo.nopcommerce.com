package Tests;

import Pages.ChangePasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ChangePasswordTest extends TestBase{

    HomePage homeObject;
    RegisterationPage registerObject;
    LoginPage loginObject;
    ChangePasswordPage changePasswordObject;

    @DataProvider(name ="registeration&login")
    public static Object[][] userData()
    {
        return new Object[][]
                {
                        {"Abdulrahmn","Alaa","abdo@gmail.com","123456789","987654321"},
                };
    }
    @Test(priority = 1, dataProvider = "registeration&login")
    public void userCanRegisterSuccessfully
            (String fname, String lname, String email, String oldPassword, String newPassword)
    {
        homeObject = new HomePage(driver);
        registerObject = new RegisterationPage(driver);
        homeObject.clickOnRegisterLinkTxt();
        registerObject.userRegisteration(fname,lname,email,oldPassword);
    }

    @Test(priority = 2, dataProvider = "registeration&login")
    public void userCanLoginSuccessfully
            (String fname, String lname, String email, String oldPassword, String newPassword)
    {
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email,oldPassword);
    }

    @Test(priority = 3, dataProvider = "registeration&login")
    public void userCanChangePasswordSuccessfully
            (String fname, String lname, String email, String oldPassword, String newPassword)
            throws InterruptedException {
        changePasswordObject = new ChangePasswordPage(driver);
        changePasswordObject.changePassword(oldPassword, newPassword);
        //Thread.sleep(500);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Assert.assertTrue(changePasswordObject.changePasswordSuccessed
                .getText().contains("Password was changed"));
    }
}
