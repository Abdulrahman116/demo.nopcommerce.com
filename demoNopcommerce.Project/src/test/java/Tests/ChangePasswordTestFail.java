package Tests;

import Pages.ChangePasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ChangePasswordTestFail extends TestBase{

    HomePage homeObject;
    RegisterationPage registerObject;
    LoginPage loginObject;
    ChangePasswordPage changePasswordObject;

    @DataProvider(name ="registeration&login")
    public static Object[][] userData()
    {
        return new Object[][]
                {
                        {"Abdulrahmn","Alaa","abdo0@gmail.com","123456789","987654321"},
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

    @Test(priority = 3)
    public void userCanChangePasswordSuccessfully() throws InterruptedException {
        changePasswordObject = new ChangePasswordPage(driver);
        changePasswordObject.changePassword("3323523", "6632554");
        Thread.sleep(500);
        Assert.assertTrue(changePasswordObject.changePasswordSuccessed
                .getText().contains("Password was changed"));
    }
}
