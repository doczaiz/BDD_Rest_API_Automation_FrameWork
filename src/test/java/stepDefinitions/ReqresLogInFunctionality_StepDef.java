package stepDefinitions;

import org.example.services.ReqRes.LogInSuccessful_Reqres;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static org.example.services.ReqRes.LogInSuccessful_Reqres.loginSuccessfulResponse;
import static org.testng.Assert.*;

public class ReqresLogInFunctionality_StepDef {
    LogInSuccessful_Reqres logInSuccessful_Reqres;

    @Given("the API endpoint for login")
    public void the_api_endpoint_for_login() {
    logInSuccessful_Reqres = new LogInSuccessful_Reqres();
    }

    @When("I send a POST request with the email {} and password {}")
    public void i_send_a_post_request_with_the_email_and_password(String email, String password) {
        loginSuccessfulResponse = logInSuccessful_Reqres.logInSuccessfulWithValidCredentials(email,password);
        loginSuccessfulResponse.log().all();
//        getLog(loginSuccessfulResponse.extract().body().asPrettyString());

    }

    @Then("the response status code should be {}")
    public void the_response_status_code_should_be(String statusCode) {
        String actualStatusCode = String.valueOf(loginSuccessfulResponse.extract().statusCode());
        Assert.assertEquals(actualStatusCode, statusCode, "Status code does not match");
    }

    @And("the response body should contain a valid token")
    public void the_response_body_should_contain_a_valid_token() {
        String token = loginSuccessfulResponse.extract().jsonPath().get("token");
        assertNotNull("Token is null or empty", token);

    }

    @And("the response body should contain an error message {}")
    public void theResponse_Body_Should_Contain_A_Error(String Errors) {
        String actualError = loginSuccessfulResponse.extract().jsonPath().get("error");
        assertEquals(actualError,Errors,"Token is not null ");
    }
}
