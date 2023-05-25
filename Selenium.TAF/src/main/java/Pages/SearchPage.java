package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
     WebElement searchTextBox;

    @FindBy(css = "button.button-1.search-box-button")
     WebElement searchButton;

    @FindBy(id = "ui-id-1")
    List<WebElement> productList;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement openProductDetails;

    public void SearchProduct(String productName)
    {
        setTextElementText(searchTextBox,productName);
        clickButton(searchButton);
    }

    public void OpenProductDetails()
    {
        clickButton(openProductDetails);
    }

    public void ProductSearchUsingAutoSuggest(String serachText)
    {
        setTextElementText(searchTextBox,serachText);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        productList.get(0).click();
    }
}
