package stepDefinitions;

import org.example.services.RestfulBooker.RestfulBookerCreateToken;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.example.services.RestfulBooker.RestfulBookerCreateToken.createTokenSuccessfulResponse;
import static org.example.services.RestfulBooker.RestfulBookerCreateToken.createTokenUnSuccessfulResponse;

public class RestfulBookerCreateToken_StepDef {
    RestfulBookerCreateToken restfulBookerCreateToken;



    @Given("the endpoint for creating a token")
    public void the_endpoint_for_creating_a_token() {
        restfulBookerCreateToken = new RestfulBookerCreateToken();
        System.out.println(restfulBookerCreateToken.testUrl);
    }
    @When("I send a post request with userName and password")
    public void i_send_a_post_request_with_user_name_and_password() {
         createTokenSuccessfulResponse = restfulBookerCreateToken.createTokenSuccessful();
         createTokenSuccessfulResponse.log().all();
        String token = createTokenSuccessfulResponse.extract().body().jsonPath().getString("token");
        System.out.println("Token >>> : "+token);


        try (FileWriter fileWriter = new FileWriter("../BDD-REST_API_Automation_Framework_QE_SUMMER2023/DataTest/tokenValue.txt")) {
            fileWriter.write(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Then("the response status code and token should be displayed")
    public void the_response_status_code_and_token_should_be_displayed() {
        int statusCode = createTokenSuccessfulResponse.extract().statusCode();
        Assert.assertEquals(statusCode,200,"the status code does not match");
        String token_value = createTokenSuccessfulResponse.extract().body().path("token");
        Assert.assertNotNull(token_value);
    }

    @When("I send a post request with wrong credentials:")
    public void i_send_a_post_request_with_wrong_credentials(io.cucumber.datatable.DataTable dataTable) {
        // Get the data from the data table
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> credential : credentials) {
            String username = credential.get("username");
            String password = credential.get("password");
            createTokenUnSuccessfulResponse = restfulBookerCreateToken.testInvalidTokenCreation(username, password);
            createTokenUnSuccessfulResponse.log().all();
        }
    }
    @Then("the response status code to create a token should be {int}")
    public void the_response_status_code_to_create_a_token_should_be(Integer int1) {
        int statusCode = createTokenUnSuccessfulResponse.extract().statusCode();
//        System.out.println(statusCode);
        Assert.assertEquals(statusCode,int1,"the status code does not match");
    }
    @Then("the reason message should be displayed {}")
    public void the_reason_message_should_be_displayed(String reason) {
        String reason_value = createTokenUnSuccessfulResponse.extract().body().path("reason");
        Assert.assertEquals(reason_value,reason,"the reason message does not match");
    }



}
