package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{
    public ComparePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "HTC One M8 Android L 5.0 Lollipop")
    public WebElement HTCmobileDevice;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement appleLaptopDevice;

    @FindBy(css = "button.button-2.remove-button")
    public WebElement removeBtn;

    @FindBy(css = "div.no-data")
    public WebElement noItemsMessage;

    public void RemoveDevice()
    {
        clickButton(removeBtn);
    }
}
