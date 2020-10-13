import org.junit.After;

public class Hooks {
    @After
    public void afterScenario() {
        System.out.println("DUPA");
    }

}
