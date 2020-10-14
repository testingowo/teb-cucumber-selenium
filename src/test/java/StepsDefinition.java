import static org.junit.Assert.assertEquals;

import demo.pages.MainDemoPage;
import io.cucumber.java8.En;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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

    public StepsDefinition() {

        Given("I navigate to {string} page", (String pageName) -> {
            WebDriverManager.chromedriver().setup();
            System.out.println(pageName);
            if(pageName.equals("wsbPage")) {
                driver = new ChromeDriver();
                mainPage = new MainPage(driver);
                mainPage.navigateToPage(pageName);
            } else if(pageName.equals("demoPage")) {
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
            driver.quit();
        });

        When("I click random post", () -> {
            mainDemoPage.clickRandomPost();
        });

        Then("I verify post form {string}", () -> {

        });
    }

    @After
    public void close() {
        driver.close();
    }
}
