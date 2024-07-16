package stepDefinitions;

import org.example.services.ReqRes.ReqresRetrieveUserDetails;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static org.example.services.ReqRes.ReqresRetrieveUserDetails.retrieveListUsersDetailsSuccessfulResponse;
import static org.example.services.ReqRes.ReqresRetrieveUserDetails.retrieveSingleUserDetailsSuccessfulResponse;



public class ReqresRetrieveUserDetails_StepDef {
    ReqresRetrieveUserDetails reqresRetrieveUserDetails;

    @Given("the API endpoint to retrieve a user details")
    public void the_api_endpoint_to_retrieve_a_user_details() {
        reqresRetrieveUserDetails = new ReqresRetrieveUserDetails();
    }

    @When("the user send Get request to retrieve a single user details")
    public void the_User_Send_Get_Request_to_retrieve_a_single_user_details() {
        retrieveSingleUserDetailsSuccessfulResponse = reqresRetrieveUserDetails.retrieveSingleUserDetailSuccessful();
//        retrieveSingleUserDetailsSuccessfulResponse.log().all();
    }

    @Then("the response should contains the following details {},{},{} and {}")
    public void the_response_should_contains_the_following_details(int Id, String first_name, String last_name, String email) {
        String actualStatusCode = String.valueOf(retrieveSingleUserDetailsSuccessfulResponse.extract().statusCode());
        Assert.assertEquals(actualStatusCode, "200", "Status code does not match");
        retrieveSingleUserDetailsSuccessfulResponse.log().all();

        int actualId = retrieveSingleUserDetailsSuccessfulResponse.extract().path("data.id");
        // Assert that the 'ID' is not null or empty
//        Assert.assertNotNull("User ID should not be null", actualId);
        Assert.assertEquals(actualId, Id);
//      validate First Name
        String actual_first_name = retrieveSingleUserDetailsSuccessfulResponse.extract().path("data.first_name");
        System.out.println("firstName : " + actual_first_name);
        Assert.assertEquals(actual_first_name, first_name, "first_name does not match");
//      validate Last Name
        String actual_last_name = retrieveSingleUserDetailsSuccessfulResponse.extract().path("data.last_name");
        Assert.assertEquals(actual_last_name, last_name, "first_name does not match");
        System.out.println("lastName : " + actual_last_name);
//      validate Email
        String actual_email = retrieveSingleUserDetailsSuccessfulResponse.extract().path("data.email");
        Assert.assertEquals(actual_email, email, "first_name does not match");
        System.out.println("lastName : " + actual_email);
    }


    @When("^the user send Get request to retrieve a list users details$")
    public void theUserSendGetRequestToRetrieveAListUsersDetails() {
        retrieveListUsersDetailsSuccessfulResponse = reqresRetrieveUserDetails.retrieveListUsersDetailsSuccessful();
    }

    @Then("^the response status code has to be equal to (.+)$")
    public void theResponseStatusCodeHasToBeEqualTo(int code) {
        int statusCode = retrieveListUsersDetailsSuccessfulResponse.extract().statusCode();
        Assert.assertEquals(statusCode, code, "Status code does not match");
        retrieveListUsersDetailsSuccessfulResponse.log().all();
        // Addition validation
        int totalPages = retrieveListUsersDetailsSuccessfulResponse.extract().path("total_pages");
        Assert.assertEquals(totalPages, 2, "Total Pages does not match");
    }

    @And("^the response must contains the following details id (.+) first name (.+) last name (.+) email (.+) and index (.+)$")
    public void theResponseMustContainsTheFollowingDetailsAnd(String Id, String first_name, String last_name, String email,int index) {
        // the response must contains the following details {},{},{} and {}
        // validate the first user in the list
        int dataIndex = index;
        Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data["+dataIndex+"].id").toString(), Id, "ID does not match for index " );
        Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data["+dataIndex+"].first_name").toString(), first_name, "first name does not match for index " );
        Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data["+dataIndex+"].last_name").toString(), last_name, "last name does not match for index " );
        Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data["+dataIndex+"].email").toString(), email, "email does not match for index " );
        // validate the second user in the list
//        Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data[1].id").toString(), Id, "ID does not match for index " );
//        Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data[1].first_name").toString(), first_name, "first name does not match for index " );
//        Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data[1].last_name").toString(), last_name, "last name does not match for index " );
//        Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data[1].email").toString(), email, "email does not match for index " );
    }

    // Different approach to validate
    @Then("the response status code has to be {int}")
    public void theResponseStatusCodeHasToBe(int arg0) {
        Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().statusCode(),arg0);
        retrieveSingleUserDetailsSuccessfulResponse.log().all();
    }
    @And("validate output details of payload")
    public void validateOutputDetailsOfPayload() {
        for (int i = 0; i < reqresRetrieveUserDetails.validateData().length; i++) {
            Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data[" + i + "].id").toString(), reqresRetrieveUserDetails.validateData()[i][0], "ID does not match for index " + i);
            Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data[" + i + "].email"), reqresRetrieveUserDetails.validateData()[i][1], "Email does not match for index " + i);
            Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data[" + i + "].first_name"), reqresRetrieveUserDetails.validateData()[i][2], "First Name does not match for index " + i);
            Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data[" + i + "].last_name"), reqresRetrieveUserDetails.validateData()[i][3], "Last Name does not match for index " + i);
            Assert.assertEquals(retrieveListUsersDetailsSuccessfulResponse.extract().path("data[" + i + "].avatar"), reqresRetrieveUserDetails.validateData()[i][4], "Avatar URL does not match for index " + i);
            System.out.println("the test pass >>> : "+ i);
        }

    }


}
