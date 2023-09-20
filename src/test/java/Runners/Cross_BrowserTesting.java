package Runners;


import Utilities.PageDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@MyTag",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)


public class Cross_BrowserTesting extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    @Parameters("browserTipi")
    public void beforeClass(String browser) {

        PageDriver.threadBrowserSet(browser);


    }
}
