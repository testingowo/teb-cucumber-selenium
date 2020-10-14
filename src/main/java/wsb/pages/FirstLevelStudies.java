package wsb.pages;

import abstractPages.AbstractPage;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstLevelStudies extends AbstractPage {

    @FindBy(css = ".horizontal-tabs > ul > li")
    private List<WebElement> tabMenu;

    public FirstLevelStudies(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getTabItemByName(String tabItemName) {
        return tabMenu.stream().filter(el -> el.getText().contains(tabItemName))
                .findFirst().orElseThrow(() -> new NoSuchElementException());
    }
}
