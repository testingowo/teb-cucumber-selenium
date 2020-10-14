package demo.pages;

import abstractPages.AbstractPage;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainDemoPage extends AbstractPage {

    @FindBy(css = "[id*='recent-posts']>ul>li>a")
    private List<WebElement> recentPosts;

    public MainDemoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickRandomPost() {
        if (recentPosts.size() > 0) {
            recentPosts.get(new Random().nextInt(recentPosts.size())).click();
        }
    }
}