package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="strong.current-item")
    public WebElement productNameBreadCrumb;

    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement emailFriendBtn;

    @FindBy(linkText = "Add your review")
    WebElement addReviewLink;

    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishlistBtn;
    @FindBy(linkText = "wishlist")
    WebElement wishlistLinkTxt;

    @FindBy(css = "button.button-2.add-to-compare-list-button")
    WebElement addToCompareListButton;

    @FindBy(linkText = "product comparison")
    WebElement goToCompareListPage;

    @FindBy(css = "button.button-1.add-to-cart-button")
    WebElement addToShoppingCartBtn;

    @FindBy(css = "span.cart-label")
    WebElement goToShoppingCartBtn;

    public void ClickOnEmailFriendBtn()
    {
        clickButton(emailFriendBtn);
    }

    public void OpenAddReviewLink()
    {
        clickButton(addReviewLink);
    }

    public void AddToWishlist()
    {
        clickButton(addToWishlistBtn);
    }

    public void GoToWishlistPage()
    {
        clickButton(wishlistLinkTxt);
    }

    public void AddToCompareListPage()
    {
        clickButton(addToCompareListButton);
    }

    public void GoToCompareListPage()
    {
        clickButton(goToCompareListPage);
    }

    public void AddToShoppingCartPage()
    {
        clickButton(addToShoppingCartBtn);
    }

    public void GoTOShoppingCartPage()
    {
        clickButton(goToShoppingCartBtn);
    }


}
