package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Print")
    WebElement printBtn;

    @FindBy(linkText = "PDF Invoice")
    WebElement downloadPDFbtn;

    @FindBy(linkText = "Log out")
    public WebElement logoutLink;

    public void PrintAndDownloadOrderDetails()
    {
        clickButton(printBtn);
        clickButton(downloadPDFbtn);
    }

    public void UserCanLogout()
    {
        clickButton(logoutLink);
    }
}
