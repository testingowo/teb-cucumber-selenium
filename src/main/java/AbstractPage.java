import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

public class AbstractPage {
    public WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage(String descriptor) throws IOException, ParseException {
        driver.navigate().to(ParseJson.getUrlByDescriptor(descriptor));
    }
}