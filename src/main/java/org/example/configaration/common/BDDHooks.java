package org.example.configaration.common;

import io.cucumber.java.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BDDHooks extends RestAPITestBase {
//Cucumber Hook:

    @Before
    public void setUpBrowser() {

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
//            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenShot, "image/png", "screenShotForDefect");
        }

    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("***************** Automation Started *******************");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("***************** Automation End *******************");
    }




}
