package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase{

    HomePage home;

    @Test
    public void UserCanChangeCurrency() throws InterruptedException {
        home = new HomePage(driver);
        home.changeCurrency();
        try {
            //Assert.assertEquals("€1032.00",home.priceOfProduct.getText());
            Assert.assertTrue(home.priceOfProduct.getText().contains("€"));
        } catch (Exception e) {
            System.out.println("Error occured >>>>> " + e.getMessage());
        }
    }
}
