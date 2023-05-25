package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement friendEmailTxt;

    @FindBy(id = "PersonalMessage")
    WebElement personalMessageTxt;

    @FindBy(css = "button.button-1.send-email-a-friend-button")
    WebElement sendEmailBtn;

    @FindBy(css = "div.result")
    public WebElement messageNotification;

    public void SendEmailToFriend(String friendEmail,String personalMessage)
    {
        setTextElementText(friendEmailTxt ,friendEmail);
        setTextElementText(personalMessageTxt ,personalMessage);
        clickButton(sendEmailBtn);
    }


}
