import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = {"com/mk/stepDefinitions"},
        tags = {"@sam"},
        plugin = {"pretty",
                "html:target/site/cucumber-pretty",
                "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/site/extent-reports/index.html"},
        monochrome = true)
public class TestRunner {

}
