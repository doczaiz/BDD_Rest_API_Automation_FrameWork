package stepDefinitions;

import org.example.services.ReqRes.ReqresRegisterUserFunctionality;
import io.cucumber.java.en.*;
import org.testng.Assert;
import static org.example.services.ReqRes.ReqresRegisterUserFunctionality.registerUserSuccessfulResponse;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;


public class ReqresRegisterUserFunctionality_StepDef {


    ReqresRegisterUserFunctionality reqresRegisterUserFunctionality;

    @Given("the API endpoint for register a user")
    public void the_API_endpoint_for_register_a_user() {
        reqresRegisterUserFunctionality = new ReqresRegisterUserFunctionality();
    }

    @When("the client sends a POST request with the following user details email {} and password {}")
    public void the_following_user_details_are_provided(String email, String password) {
        registerUserSuccessfulResponse = reqresRegisterUserFunctionality.registerUserSuccessfulWithValidCredentials(email, password);
        registerUserSuccessfulResponse.log().all();
    }


    @Then("the response status code must be {}")
    public void the_response_status_code_should_be(String statusCode) {
        String actualStatusCode = String.valueOf(registerUserSuccessfulResponse.extract().statusCode());
        Assert.assertEquals(actualStatusCode, statusCode, "Status code does not match");
    }

    @Then("the response should contain a user ID")
    public void the_response_should_contain_a_user_id() {
        // Extract the 'id' from the response body
        String actualId = registerUserSuccessfulResponse.extract().jsonPath().getString("id");
        Assert.assertEquals(actualId, "4", "Status code does not match");
        // Assert that the 'id' is not null or empty
        Assert.assertNotNull("User ID should not be null", actualId);
        Assert.assertNotEquals("User ID should not be empty", "4", actualId.trim());
        Assert.assertEquals(actualId, "4", "User ID does not match the expected value");

        // Additionally, you can use RestAssured's built-in assertion to check that 'id' is not null
        registerUserSuccessfulResponse.assertThat().body("id", notNullValue());
    }

    @And("the response should contain an error message {}")
    public void theResponseShouldContainAnErrorMessage(String errors) {
        String actualError = registerUserSuccessfulResponse.extract().jsonPath().get("error");
        assertEquals(actualError, errors, "Token is not null ");
    }
}
