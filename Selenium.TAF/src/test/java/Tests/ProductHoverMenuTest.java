package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductHoverMenuTest extends TestBase{

    HomePage homePageObject ;

    @Test
    public void UserCanSelectSubCategoryFromMainMenu()
    {
        homePageObject = new HomePage(driver);
        homePageObject.selectNotebooksMenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}
