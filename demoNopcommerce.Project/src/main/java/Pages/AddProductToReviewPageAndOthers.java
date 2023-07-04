package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToReviewPageAndOthers extends PageBase{
    public AddProductToReviewPageAndOthers(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Add your review")
    WebElement addToReviewLinKTxt;

    @FindBy(id = "AddProductReview_Title")
    WebElement addReviewTitle;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement addReviewTxt;

    @FindBy(id = "addproductrating_4")
    WebElement reviewRating;

    @FindBy(name = "add-review")
    WebElement submitReview;

    @FindBy(css = "div.result")
    public WebElement addSuccessfully;

    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishlistBtn;

    @FindBy(css = "p.content")
    public WebElement addToWishlistSuccess;

    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartBtn;

    @FindBy(linkText = "shopping cart")
    WebElement goToShoppingCart;

    public void addProductToReview(String reviewTitle,String reviewTxt)
    {
        clickButton(addToReviewLinKTxt);
        setTextElementText(addReviewTitle,reviewTitle);
        setTextElementText(addReviewTxt,reviewTxt);
        clickButton(reviewRating);
        clickButton(submitReview);
    }

    public void addProductToWishlist()
    {
        clickButton(addToWishlistBtn);
    }

    public void addProductToCartAndOpenIT()
    {
        clickButton(addToCartBtn);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickButton(goToShoppingCart);
    }
}
