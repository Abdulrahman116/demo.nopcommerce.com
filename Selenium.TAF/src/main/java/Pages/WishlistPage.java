package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.product-unit-price")
    public WebElement productPriceInWishlist;

    @FindBy(name = "updatecart")
    WebElement removeBtn;

    @FindBy(css = "div.no-data")
    public WebElement wishlistEmptyMessage;

    public void RemoveProductFromWishlist()
    {
        clickButton(removeBtn);
    }
}
