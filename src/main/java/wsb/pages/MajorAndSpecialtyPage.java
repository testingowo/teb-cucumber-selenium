package wsb.pages;

import Model.StudySubjectCard;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import abstracted.page.AbstractPage;

public class MajorAndSpecialtyPage extends AbstractPage {

    private List<StudySubjectCard> subjectCards;
    private WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(xpath = "//div[@class='filters']/div/div/label/span")
    private List<WebElement> checkBoxList;

    @FindBy(css = "[class='options'] [class='title']")
    private WebElement cityLabelTitle;

    @FindBy(xpath = "//div[@class='box']")
    private List<WebElement> checkboxes;

    @FindBy(className = "direction")
    private List<WebElement> cardLocators;

    @FindBy(className = "clear")
    private WebElement clearLink;

    @FindBy(css = "[class*='button']")
    private List<WebElement> buttons;

    @FindBy(className = "filters")
    private WebElement filter;

    @FindBy(className = "sort")
    private WebElement sort;

    @FindBy(className = "search-box")
    private WebElement search;

    public MajorAndSpecialtyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickCheckBoxByLabel(String labelName) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cityLabelTitle));
        checkBoxList.stream().filter(chkBox -> chkBox.getText().equals(labelName))
                .findFirst().get().click();
        wait.until(ExpectedConditions.visibilityOf(clearLink));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("direction"), 9));
    }

    public List<StudySubjectCard> getSubjectCards() {
        subjectCards = new ArrayList<>();
        for (WebElement subject : cardLocators) {
            subjectCards.add(new StudySubjectCard());
        }

        List<WebElement> images = driver.findElements(By.cssSelector(".direction-img > img"));
        List<WebElement> titles = driver.findElements(By.className("title"));
        List<WebElement> cities = driver.findElements(By.className("cities"));

        for (int i = 0; i < subjectCards.size(); i++) {
            subjectCards.get(i).setCardTitle(titles.get(i).getText());
            subjectCards.get(i).setCardImageUrl(images.get(i).getAttribute("src"));
            subjectCards.get(i).setCities(cities.get(i).getText());
        }

        return subjectCards;
    }

    //additional method to click all checkboxes
    public void clickCheckboxes() {
        for (WebElement checkBox : checkboxes) {
            checkBox.click();
        }
    }

    public WebElement getBtnByName(String btnName) {
        return buttons.stream().filter(btn -> btn.getText().contains(btnName))
                .findFirst().get();
    }

    public WebElement getSortBtn() {
        return sort;
    }

    public WebElement getFilterBtn() {
        return filter;
    }

    public WebElement getSearch() {
        return search;
    }
}