import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import FirstLevelStudies.AbstractPage;

public class MainPage extends AbstractPage {

    @FindBy(css = "[class='links'] > li")
    private List<WebElement> menuItems;

    @FindBy(css = ".menu.level-2>ul>li")
    private List<WebElement> studiesOptions;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getMenuItemByName(String menuItemName) {
//        PageFactory.initElements(driver, this);
        return menuItems.stream().filter(el -> el.getText().contains(menuItemName))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }

    public WebElement getOptionByDescription(String description) {
        return studiesOptions.stream().filter(el -> el.getText().contains(description))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }

    public WebElement returnPreferredMenuItem(String desc, WebElement element) {
        return studiesOptions.stream().filter(el -> el.getText().contains(desc))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }
}
