package demo.pages;

import Model.Comment;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import parser.Utils;

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

    @FindBy(css = ".comment-form-url>input")
    private WebElement commentWebsiteInput;

    @FindBy(css = "input[class='submit']")
    private WebElement submitBtn;

    @FindBy(css = "[class*='comment-author']>[class='fn']")
    private List<WebElement> publishedCommentAuthor;

    @FindBy(css = "[class*='comment-content']>p")
    private List<WebElement> publishedCommentMessage;

    private Comment comment;
    private Comment publishedComment;

    public NewPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillCommentsData() {
        comment = new Comment();
        setCommentData();
        authorInput.sendKeys(comment.getAuthor());
        commentInputField.sendKeys(comment.getCommentMessage());
        commentEmailInput.sendKeys(comment.getEmail());
        commentWebsiteInput.sendKeys(comment.getWebsite());
    }

    private void setCommentData() {
        this.comment.setAuthor(Utils.generateTestData("name"));
        this.comment.setCommentMessage(Utils.generateTestData("comment"));
        this.comment.setEmail(Utils.generateTestData("email"));
        this.comment.setWebsite(Utils.generateTestData("website"));
    }

    public boolean compareComments() {
        publishedComment = new Comment();
        publishedComment
                .setAuthor(publishedCommentAuthor.get(publishedCommentAuthor.size() - 1).getText());
        publishedComment.setCommentMessage(
                publishedCommentMessage.get(publishedCommentMessage.size() - 1).getText());
        return comment.getAuthor().equals(publishedComment.getAuthor()) &&
                comment.getCommentMessage().equals(publishedComment.getCommentMessage());
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public boolean verifyFieldLabels(String labelNames) {
        String[] labels = labelNames.trim().split(",");
        return commentInputHeader.getText().trim().contains(labels[0].trim()) && commentAuthorLabel
                .getText().trim().contains(labels[1].trim())
                && commentEmailLabel.getText().trim().contains(labels[2].trim())
                && commentWebsiteLabel.getText().trim().equals(labels[3].trim());
    }
}