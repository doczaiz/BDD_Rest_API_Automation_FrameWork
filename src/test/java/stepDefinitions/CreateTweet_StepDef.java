package stepDefinitions;

import org.example.services.Twitter.CreateTweet;

import static org.example.configaration.common.RestAPITestBase.getLog;
import static org.example.services.Twitter.CreateTweet.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.Assert;

public class CreateTweet_StepDef {

    CreateTweet createTweet;
    String tweetId;

    @Given("Twitter user have the Auth token")
    public void twitter_user_have_the_auth_token() {
        createTweet = new CreateTweet();
    }

    @When("user send a POST request to tweets endPoint")
    public void user_send_a_post_request_to_tweets_end_point() {
        createTweet = new CreateTweet();
        creteTweetSuccessfullyUsingValidAuthenticationResponse = createTweet.creteTweetSuccessfullyUsingValidAuthentication1();
        assert creteTweetSuccessfullyUsingValidAuthenticationResponse!=null;
        getLog("========= Log of creteTweetSuccessfullyUsingValidAuthenticationResponse  ==========");
        creteTweetSuccessfullyUsingValidAuthenticationResponse.log().all();
        getLog("========= Log of creteTweetSuccessfullyUsingValidAuthenticationResponse  Pretty String ==========");
        getLog(creteTweetSuccessfullyUsingValidAuthenticationResponse.extract().body().asPrettyString());

    }

    @Then("user verify the status code is {string}")
    public void user_verify_the_status_code_is(String expectedStatusCode) {
        String actualStatusCode = String.valueOf(creteTweetSuccessfullyUsingValidAuthenticationResponse.extract().statusCode());
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code does not match");

    }

    @Then("user verify the tweet message")
    public void user_verify_the_tweet_message() {
        ResponseBodyExtractionOptions responseBodyExtractionOptions;
        responseBodyExtractionOptions=creteTweetSuccessfullyUsingValidAuthenticationResponse.extract().body();
        String actualText=responseBodyExtractionOptions.path("data.text");
        Assert.assertEquals(actualText,"API Automation test2024-8","Text does not match");
    }

    @And("user verify the retweet error message")
    public void userVerifyTheRetweetErrorMessage() {
        ResponseBodyExtractionOptions responseBodyExtractionOptions;
        responseBodyExtractionOptions=creteTweetSuccessfullyUsingValidAuthenticationResponse.extract().body();
        String actualDetail=responseBodyExtractionOptions.path("detail");
        Assert.assertEquals(actualDetail,"API Automation test2024-8","detail does not match");

    }

    @Then("user verify the status code is {string} error")
    public void userVerifyTheStatusCodeIsError(String expectedStatusCode) {
        String actualStatusCode = String.valueOf(creteTweetSuccessfullyUsingValidAuthenticationResponse.extract().statusCode());
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code does not match");
    }

    @Then("user verify the status code is {string} with tweet message")
    public void user_verify_the_status_code_is_with_tweet_message(String expectedStatusCode) {
        String actualStatusCode = String.valueOf(creteTweetSuccessfullyUsingValidAuthenticationResponse.extract().statusCode());
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code does not match");

        ResponseBodyExtractionOptions responseBodyExtractionOptions;
        responseBodyExtractionOptions=creteTweetSuccessfullyUsingValidAuthenticationResponse.extract().body();
        String actualText=responseBodyExtractionOptions.path("data.text");
        Assert.assertEquals(actualText,"API Automation test2024-15","Text does not match");

    }
    @Then("user have a tweetId from the response")
    public void user_have_a_tweet_id_from_the_response() {
        ResponseBodyExtractionOptions responseBodyExtractionOptions;
        responseBodyExtractionOptions=creteTweetSuccessfullyUsingValidAuthenticationResponse.extract().body();
         tweetId=responseBodyExtractionOptions.path("data.id");

    }
    @When("user send a DELETE request to tweets endPoint following by id")
    public void user_send_a_delete_request_to_tweets_end_point_following_by_id() {
        createTweet = new CreateTweet();
        deleteTweetResponse=createTweet.deleteTweet("id", Long.valueOf(tweetId));
        assert deleteTweetResponse!=null;
    }
    @Then("user verify the status code {string} with deleted property value is {string}")
    public void user_verify_the_status_code_with_deleted_property_value_is(String expectedStatusCode, String deleted) {
        String actualStatusCode = String.valueOf(deleteTweetResponse.extract().statusCode());
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code does not match");

        ResponseBodyExtractionOptions responseBodyExtractionOptions;
        responseBodyExtractionOptions=deleteTweetResponse.extract().body();
        boolean actualDeleted=responseBodyExtractionOptions.path("data.deleted");
        Assert.assertTrue(actualDeleted, "deleted does not match");
    }



}
