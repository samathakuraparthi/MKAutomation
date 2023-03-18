import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = {"com/mk/stepDefinitions"},
        tags = "@mkTest",
        plugin = {"me.jvt.cucumber.report.PrettyReports:target/cucumber"},
        monochrome = true)
public class TestRunner {

}
