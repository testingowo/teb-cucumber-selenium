package demo.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import abstracted.page.AbstractPage;

public class MainDemoPage extends AbstractPage {

    @FindBy(css = "[id*='recent-posts']>ul>li>a")
    private List<WebElement> recentPosts;


    public MainDemoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickRandomPost() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(recentPosts.get(0)));
        Actions actions = new Actions(driver);
        actions.moveToElement(recentPosts.get(0)).build().perform();

        if (recentPosts.size() > 0) {
            recentPosts.get(new Random().nextInt(recentPosts.size())).click();
        } else {
            throw new NoSuchElementException();
        }
    }
}