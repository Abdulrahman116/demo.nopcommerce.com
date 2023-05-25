package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendTest extends TestBase{
    // 1-User regiseration
    // 2-Search for product
    // 3-Email to friend

    HomePage homeObject;
    UserRegisterationPage registerObject;
    LoginPage loginObject;
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    EmailFriendPage sendEmailObject;

    String friendEmail = "OmarSayed2@gmail.com";
    String messageTOSend = "Hello Admin, this is a test message";
    String yourEmail = "abdomohamed715@gmail.com";


    @Test(priority = 1)
    public void UserCanRegisterSuccessfuly()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject = new UserRegisterationPage(driver);
        registerObject.UserRegisteration("Abdulrahman",
                "Mohamed",yourEmail,"123456789");
        Assert.assertTrue(registerObject.SuccessMessage.getText().contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void RegisteredUserCanLogin()
    {

        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(yourEmail,"123456789");
        Assert.assertTrue(registerObject
                .logoutLink.getText().contains("Log out"));
    }

    @Test(priority = 3)
    public void UserCanSearchForProducts()
    {
        searchObject = new SearchPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        searchObject.SearchProduct(productName);
        searchObject.OpenProductDetails();
        /*Assert.assertTrue(productDetailsObject.
                productNameBreadCrumb.getText().contains(productName));
        Assert.assertEquals
                (productDetailsObject.productNameBreadCrumb.getText(),productName);*/
        productDetailsObject.ClickOnEmailFriendBtn();
    }
    @Test(priority = 4)
    public void UserCanSendEmailToFriend()
    {
        sendEmailObject = new EmailFriendPage(driver);
        sendEmailObject.SendEmailToFriend(friendEmail,messageTOSend);
        Assert.assertTrue(sendEmailObject.
                messageNotification.getText().contains("Your message has been sent."));

    }
    @Test(priority = 5)
    public void RegisteredUserCanLogout()
    {
        registerObject = new UserRegisterationPage(driver);
        registerObject.UserCanLogout();
    }
}
