package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnregisteredUserCanCheckoutProductTest extends TestBase{

    HomePage homeObject;
    UserRegisterationPage registerObject;
    SearchPage searchObject ;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;
    LoginPage loginObject;
    CheckoutPage checkoutObject;
    CheckoutPage2ShippingMethod shippingMethodObject;
    CheckoutPage3PaymentMethod paymentMethodObject;
    CheckoutPage4PaymentInformation paymentInformationObject;
    CheckoutPage5ConfirmOrder confirmOrderObject;
    CheckoutPage6CompleteOrder completeOrderObject;


    String email = "abdomoh11@gmail.com";
    String city = "Cairo";
    String address = "Esbiko";
    String zipCode = "12345";
    String phoneNumber = "01152648325";


    @Test(priority = 1)
    public void UserCanRegisterSuccessfuly()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject = new UserRegisterationPage(driver);
        registerObject.UserRegisteration("Abdulrahman",
                "Mohamed",email,"123456789");
        Assert.assertTrue(registerObject.SuccessMessage.getText().contains("Your registration completed"));
    }
    @Test(priority = 2)
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
    @Test(priority = 3)
    public void UserCanOpenShoppingCartPageUpdatingQuantity()
            throws InterruptedException {
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.GoTOShoppingCartPage();
        shoppingCartObject = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartObject.appleDevice
                .getText().contains("Apple MacBook Pro 13-inch"));
        shoppingCartObject.ChangeAppleDeviceQuantity("4");
        Thread.sleep(1000);
        shoppingCartObject.ClickOnCheckoutAndTermsBtn();
    }
    @Test(priority = 4)
    public void RegisteredUserCanLogin()
    {

        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,"123456789");
        Assert.assertTrue(registerObject
                .logoutLink.getText().contains("Log out"));
    }
    @Test(priority = 5)
    public void UserCanOpenShoppingCartPageUpdatingQuantity2()
            throws InterruptedException {
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.GoTOShoppingCartPage();
        shoppingCartObject = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartObject.appleDevice
                .getText().contains("Apple MacBook Pro 13-inch"));
        shoppingCartObject.ChangeAppleDeviceQuantity("4");
        Thread.sleep(1000);
        shoppingCartObject.ClickOnCheckoutAndTermsBtn();
    }
    @Test(priority = 6)
    public void UserCanOpenCheckoutAndFillBillingAddress(){
        checkoutObject = new CheckoutPage(driver);
        checkoutObject.FillingBillingAddress(city,
                address,zipCode,phoneNumber);
    }
    @Test(priority = 7)
    public void UserCanChooseTheShippingMethod() throws InterruptedException {
        shippingMethodObject = new CheckoutPage2ShippingMethod(driver);
        Thread.sleep(500);
        shippingMethodObject.ChoosingShippingMethod();
    }
    @Test(priority = 8)
    public void UserCanChooseThePaymentMethod() throws InterruptedException {
        paymentMethodObject = new CheckoutPage3PaymentMethod(driver);
        Thread.sleep(500);
        paymentMethodObject.ChoosingPaymentMethod();
    }
    @Test(priority = 9)
    public void UserCanConfirmThePaymentInformation() throws InterruptedException {
        paymentInformationObject = new CheckoutPage4PaymentInformation(driver);
        Thread.sleep(500);
        paymentInformationObject.ConfirmPaymentInformation();
    }
    @Test(priority = 10)
    public void UserCanConfirmOrder() throws InterruptedException {
        confirmOrderObject = new CheckoutPage5ConfirmOrder(driver);
        Thread.sleep(500);
        confirmOrderObject.ConfirmOrder();
    }
    @Test(priority = 11)
    public void UserCanCompleteOrder() throws InterruptedException {
        completeOrderObject = new CheckoutPage6CompleteOrder(driver);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("checkout/completed"));
        completeOrderObject.CompleteOrder();
    }
    @Test(priority = 12)
    public void UserCanLogout(){
        homeObject = new HomePage(driver);
        homeObject.UserCanLogout();
    }
}
