import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import demo.pages.MainDemoPage;
import demo.pages.NewPostPage;
import io.cucumber.java8.En;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wsb.pages.FirstLevelStudies;
import wsb.pages.MainPage;
import wsb.pages.MajorAndSpecialtyPage;

public class StepsDefinition implements En {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected MainDemoPage mainDemoPage;
    protected FirstLevelStudies firstLevelStudies;
    protected MajorAndSpecialtyPage majorAndSpecialtyPage;
    protected NewPostPage newPostPage;

    public StepsDefinition() {

        Given("I navigate to {string} page", (String pageName) -> {
            WebDriverManager.chromedriver().ignoreVersions("91");
            WebDriverManager.chromedriver().setup();
            System.out.println(pageName);
            if (pageName.equals("wsbPage")) {
                driver = new ChromeDriver();
                mainPage = new MainPage(driver);
                mainPage.navigateToPage(pageName);
            } else if (pageName.equals("demoPage")) {
                driver = new ChromeDriver();
                mainDemoPage = new MainDemoPage(driver);
                mainDemoPage.navigateToPage(pageName);
            }
        });

        When("I click menu item with text {string}", (String menuItemName) -> {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(mainPage.getMenuItemByName(menuItemName)));
            mainPage.getMenuItemByName(menuItemName).click();
        });

        When("I click submenu item with text {string}", (String menuItemName) -> {
            mainPage.getOptionByDescription(menuItemName).click();
        });

        When("I click {string} in tab menu", (String tabName) -> {
            firstLevelStudies = new FirstLevelStudies(driver);
            firstLevelStudies.getTabItemByName(tabName).click();
        });

        When("I select {string} city from the left menu", (String cityName) -> {
            majorAndSpecialtyPage = new MajorAndSpecialtyPage(driver);
            majorAndSpecialtyPage.clickCheckBoxByLabel(cityName);
        });

        Then("{string} search results should be displayed", (String numberOfCards) -> {
            int expectedNumberOfCards = Integer.parseInt(numberOfCards);

            assertEquals("Search result should equal ", expectedNumberOfCards,
                    majorAndSpecialtyPage.getSubjectCards().size());
        });

        Then("Each result contains {string} city", (String city) -> {
            for (int i = 0; i < majorAndSpecialtyPage.getSubjectCards().size(); i++) {
                assertTrue(
                        majorAndSpecialtyPage.getSubjectCards().get(i).getCities().contains(city));
                assertTrue(!majorAndSpecialtyPage.getSubjectCards().get(i).getCardImageUrl()
                        .isEmpty());
            }
        });

        Then("{string} button is displayed", (String btnName) -> {
            assertTrue(majorAndSpecialtyPage.getBtnByName(btnName).isDisplayed());
        });

        Then("Sorting, filters and search field are displayed", () -> {
            assertTrue(majorAndSpecialtyPage.getSortBtn().isDisplayed() &&
                    majorAndSpecialtyPage.getFilterBtn().isDisplayed() &&
                    majorAndSpecialtyPage.getSearch().isDisplayed());
            driver.quit();
        });

        When("I click random post", () -> {
            mainDemoPage.clickRandomPost();
        });

        Then("I verify post form {string}", (String labelNames) -> {
            newPostPage = new NewPostPage(driver);
            assertTrue(newPostPage.verifyFieldLabels(labelNames));
        });

        When("I fill comment fields", () -> {
            newPostPage.fillCommentsData();
        });

        When("I click submit button", () -> {
            newPostPage.clickSubmitBtn();
            newPostPage.compareComments();
        });

        Then("I compare added and generated comment", () -> {
            Assert.assertTrue(newPostPage.compareComments());
            driver.close();
        });
    }
}