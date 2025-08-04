package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        snippets = SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:target/serenity-report",
                "json:target/cucumber-report/cucumber.json"
        },
        monochrome = true,
        dryRun = false
)
public class Runner {
}