package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select  select ;
    public Actions action ;

    //Create Constructor
    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    //Method to click on any Btn
    protected static void clickButton(WebElement button)
    {
        button.click();
    }
    //Method to enter elements in any Txt Box
    protected static void setTextElementText(WebElement TextElement, String value)
    {
        TextElement.sendKeys(value);
    }
    //Method to scroll a page
    public void scrollToBotton()
    {
        jse.executeScript("scrollBy(0,2500)");
    }
}
