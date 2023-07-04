package Tests;

import Pages.HomePage;
import Pages.RegisterationPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterWithDDD extends TestBase{

    HomePage homeObject;
    RegisterationPage registerObject;

    @DataProvider(name ="registeration")
    public static Object[][] userData()
    {
        return new Object[][]
                {
                        {"Abdulrahmn","Alaa","abdo15@gmail.com","123456789"},
                        {"Abdulrahmn","Alaa","abdo16@gmail.com","123456789"},
                        {"Abdulrahmn","Alaa","abdo17@gmail.com","123456789"},
                        {"Abdulrahmn","Alaa","abdo18@gmail.com","123456789"},
                        {"Abdulrahmn","Alaa","abdo19@gmail.com","123456789"},
                };
    }

    @Test(priority = 1, dataProvider = "registeration")
    public void userCanRegisterSuccessfully
            (String fname, String lname, String email, String password)
    {
        homeObject = new HomePage(driver);
        registerObject = new RegisterationPage(driver);
        homeObject.clickOnRegisterLinkTxt();
        registerObject.userRegisteration(fname,lname,email,password);
    }
}
