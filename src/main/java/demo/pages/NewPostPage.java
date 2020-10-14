package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPostPage extends abstractPages.AbstractPage {

    @FindBy(id = "respond")
    private WebElement commentForm;

    @FindBy(tagName = "h3")
    private WebElement replyHeader;

    @FindBy(className = "comment-notes")
    private WebElement replyMessage;

    @FindBy(css = ".comment-form-comment>label")
    private WebElement commentInputHeader;

    @FindBy(css = ".comment-form-comment>textarea")
    private WebElement commentInputField;

    @FindBy(css = ".comment-form-author>label")
    private WebElement commentAuthorLabel;

    @FindBy(css = ".comment-form-author>input")
    private WebElement authorInput;

    @FindBy(css = ".comment-form-email>label")
    private WebElement commentEmailLabel;

    @FindBy(css = ".comment-form-email>input")
    private WebElement commentEmailInput;

    @FindBy(css = ".comment-form-url>label")
    private WebElement commentWebsiteLabel;

    @FindBy(css = ".comment-form-url>label")
    private WebElement commentWebsiteInput;

    @FindBy(css = "input[class='submit']")
    private WebElement submitBtn;

    public NewPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
