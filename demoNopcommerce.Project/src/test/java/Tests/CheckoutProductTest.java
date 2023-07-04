package Tests;

import Pages.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckoutProductTest extends TestBase{

    HomePage homeObject;
    RegisterationPage registerObject;
    LoginPage loginObject;
    ProductDetailsPage productObject;
    AddProductToReviewPageAndOthers addProductObject;
    CheckoutProductPage checkoutProductObject;



    String product = "Apple MacBook Pro 13-inch";


    @DataProvider(name ="registeration&login")
    public static Object[][] userData()
    {
        return new Object[][]
                {
                        {"Abdulrahmn","Alaa","abdo4@gmail.com","123456789"},
                };
    }
    @DataProvider(name ="Checkout")
    public static Object[][] CheckoutData()
    {
        return new Object[][]
                {
                        {"Cairo","El-salam","11511","01128521639"},
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
        addProductObject = new AddProductToReviewPageAndOthers(driver);
        productObject.productDetailsSuccess();
        addProductObject.addProductToCartAndOpenIT();
    }
    @Test(priority = 4,dataProvider = "Checkout")
    public void userCanAddProductToCheckout
            (String city, String address, String zipCode, String phoneNumber)
    {
        checkoutProductObject = new CheckoutProductPage(driver);
        homeObject = new HomePage(driver);
        checkoutProductObject.addProductToCheckout(city, address, zipCode, phoneNumber);
        homeObject.clickOnlogoutLinkTxt();
    }
}
