package Tests;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase{

    HomePage home;
    ContactUsPage contactUs;

    String email = "abdomohamed43@gmail.com";
    String fullName = "Abdulrahman";
    String enquiry = "Hello admin, this is a test message";


    @Test
    public void UserCanContactUs() {
        home = new HomePage(driver);
        contactUs = new ContactUsPage(driver);
        home.openContactUsPage();
        contactUs.ContactUs(fullName,email,enquiry);
        Assert.assertTrue(contactUs.succesMessage.getText()
                .contains("Your enquiry has been successfully sent to the store owner."));
    }
}
