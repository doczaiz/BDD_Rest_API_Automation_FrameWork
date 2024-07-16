package stepDefinitions;

import org.example.services.ReqRes.ReqresUpdateUserDetails;
import io.cucumber.java.en.*;
import org.testng.Assert;
import static org.example.services.ReqRes.ReqresUpdateUserDetails.updateUserSuccessfulResponse;

public class ReqresUpdateUserDetails_StepDef {
    ReqresUpdateUserDetails reqresUpdateUserDetails;
    @Given("the API endpoint to update a user details")
    public void the_api_endpoint_to_update_a_user_details() {
        reqresUpdateUserDetails = new ReqresUpdateUserDetails();
    }
    @When("the client sends a Put request with the following user details name {} and job {}")
    public void the_client_sends_a_put_request_with_the_following_user_details_name_and_job(String name,String job) {
        updateUserSuccessfulResponse = reqresUpdateUserDetails.updateUserSuccessfulWithValidCredentials(name,job);
        updateUserSuccessfulResponse.log().all();
    }
    @Then("the response status-code must be {}")
    public void the_response_status_code_must_be(String code) {
        String actualStatusCode = String.valueOf(updateUserSuccessfulResponse.extract().statusCode());
        Assert.assertEquals(actualStatusCode,code, "Status code does not match");
    }
    @And("the response should contain an update time reference message {}")
    public void theResponseShouldContainAnUpdateTimeReferenceMessage(String arg0) {
        String actualId = updateUserSuccessfulResponse.extract().jsonPath().getString("updatedAt");
        // Assert that the 'updatedAt' is not null or empty
        Assert.assertNotNull("User ID should not be null", actualId);
    }

    @When("the client sends a Put request with the following user name {}")
    public void theClientSendsAPutRequestWithTheFollowingUserDetailsName(String name) {
        updateUserSuccessfulResponse = reqresUpdateUserDetails.updateUserNameSuccessfulWithValidCredentials(name);
        updateUserSuccessfulResponse.log().all();
    }

    @When("the client sends a Put request to update job title {}")
    public void theClientSendsAPutRequestToUpdateJobTitle(String job) {
        updateUserSuccessfulResponse = reqresUpdateUserDetails.updateUserJobSuccessfulWithValidCredentials(job);
        updateUserSuccessfulResponse.log().all();
    }


}
