package Tests;

import Pages.ComparePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCompareTest extends TestBase{

    SearchPage searchObject;

    ProductDetailsPage productDetailsObject;
    ComparePage compareObject;
    @Test(priority = 1)
    public void UserCanTestWithAutoSuggect()
    {
        try {
            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("Apple MacBook");
        } catch (Exception e) {
            System.out.println("Error occured here  >>>>>  " + e.getMessage());
        }
    }
    @Test(priority = 2)
    public void UserCanAddProductToCompareList()
    {
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.AddToCompareListPage();
    }
    @Test(priority = 3)
    public void UserCanTestWithAutoSuggect2()
    {
        try {
            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("HTC One M8");
        } catch (Exception e) {
            System.out.println("Error occured here  >>>>>  " + e.getMessage());
        }
    }
    @Test(priority = 4)
    public void UserCanAddProductToCompareList2AndOpenListPage()
    {
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.AddToCompareListPage();
        productDetailsObject.GoToCompareListPage();
        compareObject = new ComparePage(driver);
        Assert.assertTrue(compareObject.appleLaptopDevice
                .getText().contains("Apple MacBook Pro 13-inch"));
        compareObject = new ComparePage(driver);
        Assert.assertTrue(compareObject.HTCmobileDevice
                .getText().contains("HTC One M8 Android L 5.0 Lollipop"));
    }
    @Test(priority = 5)
    public void RemoveProductsFromCompareListPage()
    {
        compareObject = new ComparePage(driver);
        compareObject.RemoveDevice();
        compareObject.RemoveDevice();
        Assert.assertTrue(compareObject.noItemsMessage
                .getText().contains("You have no items to compare."));
    }
}
