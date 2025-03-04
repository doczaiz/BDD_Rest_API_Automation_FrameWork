package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions","org.example.configuration.common"},
        monochrome = true,
        publish = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/index.html",
                "json:target/cucumber-reports/cucumber-report.json",
                "junit:target/cucumber-reports/cucumber-results.xml",
                "pretty:target/cucumber-reports/cucumber-pretty.txt",
                "rerun:target/cucumber-reports/rerun.txt",
                "rerun:target/cucumber-reports/cucumber-report.yml"
        },
//        tags = "@RegressionTest and not @pending"
//        tags = "@SmokeTest and not @pending"
        tags = "@Mahmud and not @pending"

)



public class RegressionTestRunner extends AbstractTestNGCucumberTests {

//
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//
//    @Before
//    public void beforeScenario(Scenario scenario) {
//
//    }
//
//    private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass()
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    @Test(dataProvider = "features")
//    public void my_test(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }
//
//
//    @DataProvider
//    public Object[][] features() {
//        return testNGCucumberRunner.provideFeatures();
//    }
//
//
//    @AfterClass
//    public void tearDown() {
//        testNGCucumberRunner.finish();
//    }
//









}
