package Tests;

import Pages.AddProductToReviewPageAndOthers;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToWishlistTestFail extends TestBase{

    HomePage homeObject;
    ProductDetailsPage productObject;
    AddProductToReviewPageAndOthers addProductObject;

    String product = "%%%%%";

    @Test(priority = 1)
    public void userCanLoginAndSearchProductSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.searchProduct(product);
    }

    @Test(priority = 2)
    public void userCanOpenProductDetails()
    {
        productObject = new ProductDetailsPage(driver);
        productObject.productDetailsSuccess();
    }

    @Test(priority = 3)
    public void userCanAddProductToWishlist()
    {
        addProductObject = new AddProductToReviewPageAndOthers(driver);
        addProductObject.addProductToWishlist();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(addProductObject.addToWishlistSuccess
                .getText().contains("The product has been added to your "));
    }
}
