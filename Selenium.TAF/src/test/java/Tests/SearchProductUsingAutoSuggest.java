package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductUsingAutoSuggest extends TestBase{

    String productName = "$25 Virtual Gift Card";

    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;

    @Test
    public void UserCanTestWithAutoSuggect()
    {
        try {
            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("$25");
            productDetailsObject = new ProductDetailsPage(driver);
            Assert.assertTrue(productDetailsObject.
                    productNameBreadCrumb.getText().contains(productName));
            //Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
        } catch (Exception e) {
            System.out.println("Error occured here  >>>>>  " + e.getMessage());
        }

    }

}
