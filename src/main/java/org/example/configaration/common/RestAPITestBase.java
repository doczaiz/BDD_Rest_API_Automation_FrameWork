package org.example.configaration.common;

import org.example.configaration.utilities.ReadPropertiesFrom;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class RestAPITestBase {
    public static Properties readConfigurationProperties = ReadPropertiesFrom.loadProperties("src/main/resources/configProperty/Configuration.properties");
    public static Properties readApiEndPointsProperties = ReadPropertiesFrom.loadProperties("src/main/resources/configProperty/apiEndPoints.properties");
    public static Properties readReqresApiEndPointsProperties = ReadPropertiesFrom.loadProperties("src/main/resources/configProperty/ReqresApiEndPoints.properties");
    public static Properties readRestfulBookerApiEndPointsProperties = ReadPropertiesFrom.loadProperties("src/main/resources/configProperty/RestfulBookerApiEndPonits.properties");


    public static final String apiKey=readConfigurationProperties.getProperty("apiKey");
    public static final String apiSecretKey=readConfigurationProperties.getProperty("apiSecretKey");
    public static final String accessToken=readConfigurationProperties.getProperty("accessToken");
    public static final String accessTokenSecret=readConfigurationProperties.getProperty("accessTokenSecret");
    public static final String bearerToken=readConfigurationProperties.getProperty("bearerToken");
    public static final String clientId=readConfigurationProperties.getProperty("clientId");
    public static final String clientSecret=readConfigurationProperties.getProperty("clientSecret");

    // Base URL
    public String baseURL_reqRes="https://reqres.in/";

    public static String baseURL_twitterIncludingVersion=readConfigurationProperties.getProperty("QA_ENV_URL")+readConfigurationProperties.getProperty("API_VERSION");
    public static String baseURL_Reqres=readConfigurationProperties.getProperty("Reqres_Base_Url");
    public static String baseURL_RestfulBooker=readConfigurationProperties.getProperty("RestfulBooker_Base_Url");
    public static String token_RestfulBooker=readConfigurationProperties.getProperty("RestfulBooker_Token");

    public static String BROWSER_NAME = readConfigurationProperties.getProperty("BROWSER_NAME");
    public static String BROWSER_VERSION = readConfigurationProperties.getProperty("BROWSER_VERSION");
    public static String ENVIRONMENT_NAME = readConfigurationProperties.getProperty("ENVIRONMENT_NAME");
    public static String OS = readConfigurationProperties.getProperty("OS");
    public static String OS_VERSION = readConfigurationProperties.getProperty("OS_VERSION");

    public static String envURL = readConfigurationProperties.getProperty("QA_ENV_URL");
    public static String BROWSERSTACK_USER_NAME = readConfigurationProperties.getProperty("BROWSERSTACK_USER_NAME");
    public static String BROWSERSTACK_ACCESS_KEY = readConfigurationProperties.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static String SAUCE_LABS_USERNAME = readConfigurationProperties.getProperty("SAUCE_LABS_USERNAME");
    public static String SAUCE_LABS_ACCESS_KEY = readConfigurationProperties.getProperty("SAUCE_LABS_ACCESS_KEY");


    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }


    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }


    public static String convertToString(String st) {
        String splitString = "";
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }


    public static void getLog(final String message) {
        Reporter.log(message, true);
    }


    public void setUpAutomation() {
        System.out.println("================ Automation Test Case Execution Start ===========");
    }


    public void endAutomation() {
        System.out.println("================ Automation Test Case Execution End ===========");
    }


    public void beforeTestMethodStart() {
        System.out.println("================ Before Test Method Start ===========");
    }


    public void afterTestMethodStart() {
        System.out.println("================ After Test Method End ===========");
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
