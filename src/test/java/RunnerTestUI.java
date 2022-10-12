
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/UI_features",
        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "json:target/cucumber.json", "html:test-output" },
        glue = {"UI_test/StepDefinition", "Hooks"},
        tags = "@Test_UI"
)

public class RunnerTestUI {

    @BeforeClass
    public static void before() {
            SelenideLogger.addListener("AllureSelenide",
                    new AllureSelenide().
                            screenshots(true).
                            savePageSource(false));
    }
}