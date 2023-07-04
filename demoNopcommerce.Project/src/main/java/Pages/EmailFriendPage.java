package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement friendEmailTxtBox;

    @FindBy(id = "PersonalMessage")
    WebElement messageTxtBox;

    @FindBy(name = "send-email")
    WebElement sendEmailBtn;

    @FindBy(css = "div.result")
    public WebElement messageSent;

    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement emailFriendBtn;

    public void sendEmail(String friendEmail, String message)
    {
        clickButton(emailFriendBtn);
        setTextElementText(friendEmailTxtBox, friendEmail);
        setTextElementText(messageTxtBox, message);
        clickButton(sendEmailBtn);
    }
}
