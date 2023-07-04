package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddProductToReviewTestFail extends TestBase{

    HomePage homeObject;
    //RegisterationPage registerObject;
    //LoginPage loginObject;

    ProductDetailsPage productObject;
    AddProductToReviewPageAndOthers addProductToReviewObject;

    String product = "Apple MacBook Pro 13-inch";

    /*@DataProvider(name ="registeration&login")
    public static Object[][] userData()
    {
        return new Object[][]
                {
                        {"Abdulrahmn","Alaa","abdo9@gmail.com","123456789"},
                };
    }*/
    @DataProvider(name ="addReview")
    public static Object[][] reviewData()
    {
        return new Object[][]
                {
                        {"Review about this Mac","This mac device is very good"},
                };
    }
    /*@Test(priority = 1, dataProvider = "registeration&login")
    public void userCanRegisterSuccessfully
            (String fname, String lname, String email, String password)
    {
        homeObject = new HomePage(driver);
        registerObject = new RegisterationPage(driver);
        homeObject.clickOnRegisterLinkTxt();
        registerObject.userRegisteration(fname,lname,email,password);
    }*/

    @Test(priority = 2, dataProvider = "registeration&login")
    public void userCanLoginAndSearchProductSuccessfully
            (String fname, String lname, String email, String password )
    {
        //loginObject = new LoginPage(driver);
        homeObject = new HomePage(driver);
        //loginObject.userLogin(email,password);
        homeObject.searchProduct(product);
    }

    @Test(priority = 3)
    public void userCanOpenProductDetails()
    {
        productObject = new ProductDetailsPage(driver);
        productObject.productDetailsSuccess();
    }

    @Test(priority = 4,dataProvider = "addReview")
    public void userCanAddProductToReview(String reviewTitle,String reviewTxt)
            throws InterruptedException {
        addProductToReviewObject = new AddProductToReviewPageAndOthers(driver);
        homeObject = new HomePage(driver);
        addProductToReviewObject.addProductToReview(reviewTitle, reviewTxt);
        Thread.sleep(500);
        Assert.assertTrue(addProductToReviewObject.addSuccessfully
                .getText().contains("Product review is successfully added."));
        homeObject.clickOnlogoutLinkTxt();
    }
}
