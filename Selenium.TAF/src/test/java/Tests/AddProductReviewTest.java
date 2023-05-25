package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductReviewTest extends TestBase{

    HomePage homeObject;
    UserRegisterationPage registerObject;
    LoginPage loginObject;
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ProductReviewPage productReviewObject;
    String email = "abdomohamed500@gmail.com" ;
    String productName = "Apple MacBook Pro 13-inch" ;
    String reviewTitle = "Test";
    String reviewMessage = "This is a review message for test";
    @Test(priority = 1)
    public void UserCanRegisterSuccessfuly()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject = new UserRegisterationPage(driver);
        registerObject.UserRegisteration("Abdulrahman",
                "Mohamed",email,"123456789");
        Assert.assertTrue(registerObject.SuccessMessage.getText().contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void RegisteredUserCanLogin()
    {

        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,"123456789");
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
        Assert.assertTrue(productDetailsObject.
                productNameBreadCrumb.getText().contains(productName));
        //Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }

    @Test(priority = 4)
    public void UserCanAddReviewForProduct()
    {
        productDetailsObject = new ProductDetailsPage(driver);
        productReviewObject = new ProductReviewPage(driver);
        productDetailsObject.OpenAddReviewLink();
        productReviewObject.AddProductReview(reviewTitle,reviewMessage);
        Assert.assertTrue(productReviewObject.reviewSuccesMessage.
                getText().contains("Product review is successfully added."));
    }

    @Test(priority = 5)
    public void UserCanLogout()
    {
        registerObject = new UserRegisterationPage(driver);
        registerObject.UserCanLogout();
    }


}
