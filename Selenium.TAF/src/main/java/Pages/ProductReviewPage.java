package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitleTxt;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTxtTxt;

    @FindBy(id = "addproductrating_4")
    WebElement rating4RdoBtn;

    @FindBy(name = "add-review")
    WebElement submitReviewBtn;

    @FindBy(css = "div.result")
    public WebElement reviewSuccesMessage;

    public void AddProductReview(String reviewTitle, String reviewTxt)
    {
        setTextElementText(reviewTitleTxt,reviewTitle);
        setTextElementText(reviewTxtTxt,reviewTxt);
        clickButton(rating4RdoBtn);
        clickButton(submitReviewBtn);
    }
}
