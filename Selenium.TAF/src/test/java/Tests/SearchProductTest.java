package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{

    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;

    @Test
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
}
