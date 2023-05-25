package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddProductToWishlistTest extends TestBase {

    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    WishlistPage wishlistObject;


    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void UserCanAddProductToWishlistPage(){
        productDetailsObject = new ProductDetailsPage(driver);
        wishlistObject = new WishlistPage(driver);
        productDetailsObject.AddToWishlist();
        productDetailsObject.GoToWishlistPage();
        Assert.assertTrue(wishlistObject.productPriceInWishlist.getText().contains("$1,800.00"));
    }

   @Test(priority = 3)
    public void UserCanRemoveProductFromWishlist(){
        wishlistObject = new WishlistPage(driver);
        wishlistObject.RemoveProductFromWishlist();
        Assert.assertTrue(wishlistObject.wishlistEmptyMessage
                    .getText().contains("The wishlist is empty!"));
    }

}
