package stepDefinitions;

import org.example.services.ReqRes.ReqresCreateUser;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static org.example.services.ReqRes.ReqresCreateUser.reqresCreateUserSuccessfulResponse;

public class ReqresCreateUser_StepDef {
    ReqresCreateUser reqresCreateUser;

    @Given("the API endpoint for creating a user")
    public void the_api_endpoint_for_creating_a_user() {
        reqresCreateUser = new ReqresCreateUser();
    }
    @When("I send a Post request to create a user")
    public void I_send_a_post_request_to_create_a_user() {
        reqresCreateUserSuccessfulResponse = reqresCreateUser.createUserSuccessful();
        reqresCreateUserSuccessfulResponse.log().all();
    }
    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int arg0) {
        int actualStatusCode = reqresCreateUserSuccessfulResponse.extract().statusCode();
        Assert.assertEquals(actualStatusCode,arg0,"the status code does not match");
    }
    @And("the response should contain name and job")
    public void the_response_should_contain_name_and_job() {
        String actualName = reqresCreateUserSuccessfulResponse.extract().body().path("name");
        String expectedName = "morpheus";
        Assert.assertEquals(actualName,expectedName,"the name does not match");
        String actualJob = reqresCreateUserSuccessfulResponse.extract().body().path("job");
        Assert.assertNotNull(actualJob);
    }



}
