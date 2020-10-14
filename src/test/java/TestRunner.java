import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/wsb.feature"},
        plugin = { "pretty", "html:target/htmlreports" }
)

public class TestRunner {

}
