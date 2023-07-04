package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmailFriendTestFail extends TestBase{

    HomePage homeObject;
    RegisterationPage registerObject;
    LoginPage loginObject;

    ProductDetailsPage productObject;
    EmailFriendPage emailFriendobject;

    String product = "Apple MacBook Pro 13-inch";

    @DataProvider(name ="registeration&login")
    public static Object[][] userData()
    {
        return new Object[][]
                {
                        {"Abdulrahmn","Alaa","abdo2@gmail.com","123456789"},
                };
    }
    @DataProvider(name ="emailFriend")
    public static Object[][] emailData()
    {
        return new Object[][]
                {
                        {"omargmail.com","The message for my friend"},
                };
    }
    @Test(priority = 1, dataProvider = "registeration&login")
    public void userCanRegisterSuccessfully
            (String fname, String lname, String email, String password)
    {
        homeObject = new HomePage(driver);
        registerObject = new RegisterationPage(driver);
        homeObject.clickOnRegisterLinkTxt();
        registerObject.userRegisteration(fname,lname,email,password);
    }

    @Test(priority = 2, dataProvider = "registeration&login")
    public void userCanLoginAndSearchProductSuccessfully
            (String fname, String lname, String email, String password )
    {
        loginObject = new LoginPage(driver);
        homeObject = new HomePage(driver);
        loginObject.userLogin(email,password);
        homeObject.searchProduct(product);
    }

    @Test(priority = 3)
    public void userCanOpenProductDetails()
    {
        productObject = new ProductDetailsPage(driver);
        productObject.productDetailsSuccess();
    }

    @Test(priority = 4, dataProvider = "emailFriend")
    public void userCanSendMailToFriend(String friendEmail,String message)
    {
        emailFriendobject = new EmailFriendPage(driver);
        emailFriendobject.sendEmail(friendEmail, message);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(emailFriendobject.messageSent.getText()
                .contains("Your message has been sent."));
    }
}
