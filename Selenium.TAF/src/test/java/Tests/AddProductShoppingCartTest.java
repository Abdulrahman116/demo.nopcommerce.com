package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductShoppingCartTest extends TestBase{

    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;

    @Test(priority = 1)
    public void UserCanTestWithAutoSuggect()
    {
        try {
            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("Apple MacBook");
            productDetailsObject = new ProductDetailsPage(driver);
            productDetailsObject.AddToShoppingCartPage();
        } catch (Exception e) {
            System.out.println("Error occured here  >>>>>  " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void UserCanOpenShoppingCartPageUpdatingQuantity(){
            productDetailsObject = new ProductDetailsPage(driver);
            productDetailsObject.GoTOShoppingCartPage();
            shoppingCartObject = new ShoppingCartPage(driver);
            Assert.assertTrue(shoppingCartObject.appleDevice
                    .getText().contains("Apple MacBook Pro 13-inch"));
            shoppingCartObject.ChangeAppleDeviceQuantity("4");
            shoppingCartObject.RemoveDeviceFromCart();
            Assert.assertTrue(shoppingCartObject.cartEmptyMessage
                    .getText().contains("Your Shopping Cart is empty!"));
    }
}
