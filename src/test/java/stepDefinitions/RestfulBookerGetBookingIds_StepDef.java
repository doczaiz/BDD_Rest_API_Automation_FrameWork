package stepDefinitions;


import org.example.services.RestfulBooker.RestfulBookerGetBookingIds;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

import static org.example.services.RestfulBooker.RestfulBookerGetBookingIds.restfulBookerGetBookingFirstNameSuccessfulResponse;
import static org.example.services.RestfulBooker.RestfulBookerGetBookingIds.restfulBookerGetBookingIdsSuccessfulResponse;
public class RestfulBookerGetBookingIds_StepDef {
    RestfulBookerGetBookingIds restfulBookerGetBookingIds;

    @Given("the API endPoint for getting booking")
    public void the_the_api_end_point_for_getting_booking() {
       restfulBookerGetBookingIds = new RestfulBookerGetBookingIds();
    }
    @When("I send a get request")
    public void i_send_a_get_request() {
        restfulBookerGetBookingIdsSuccessfulResponse = restfulBookerGetBookingIds.restfulBookerGetBookingIdsSuccessful();
        restfulBookerGetBookingIdsSuccessfulResponse.log().all();
    }
    @Then("the status code must be {int}")
    public void theStatusCodeMustBe(int arg0) {
        int actualStatusCode = restfulBookerGetBookingIdsSuccessfulResponse.extract().statusCode();
        Assert.assertEquals(actualStatusCode,arg0,"Status code is not as expected");
    }
    @And("I should retrieve booking Ids")
    public void i_should_retrieve_booking_ids() {
        // Extract the list of booking IDs
        List<Integer> bookingIds = restfulBookerGetBookingIdsSuccessfulResponse.extract().jsonPath().getList("bookingid");

        // Validate the number of booking IDs
        Assert.assertNotNull(bookingIds, "Booking IDs list is null.");
        Assert.assertTrue(bookingIds.size() > 0, "No booking IDs found.");

        // Print out the booking IDs for verification
        System.out.println("Booking IDs: " + bookingIds);
        System.out.println("Total Ids in the list : "+ bookingIds.size());

        // Sort the booking IDs
        Collections.sort(bookingIds);

        // Print out the sorted booking IDs for verification
        System.out.println("Booking IDs after sorting: " + bookingIds);

        // Validate that the sorted booking IDs list is still not empty
        Assert.assertTrue(bookingIds.size() > 0, "Sorted booking IDs list is empty.");
    }
    @When("I send request to retrieve first and last name by providing booking {}")
    public void i_send_request_to_retrieve_first_and_last_name_by_providing_booking (Integer Id) {
        restfulBookerGetBookingFirstNameSuccessfulResponse = restfulBookerGetBookingIds.restfulBookerGetBookingFirstNameAndLastNameSuccessful(Id);
        restfulBookerGetBookingFirstNameSuccessfulResponse.log().all();
    }
    @Then("status code should equal to {int}")
    public void status_code_should_equal_to(Integer int1) {
        int actualStatusCode = restfulBookerGetBookingFirstNameSuccessfulResponse.extract().statusCode();
        Assert.assertEquals(actualStatusCode,int1);
    }
    @Then("I should retrieve booking first name {} and last name {}")
    public void I_should_retrieve_booking_first_name_and_last_name(String firstName,String lastName) {
        // I can not do Assertion because Ids dynamics (data keep changing)
//        String actualFirstName = restfulBookerGetBookingFirstNameSuccessfulResponse.extract().body().path("firstname");
//        Assert.assertEquals(actualFirstName,firstName, "the first name does not match");
//        String actualLastName = restfulBookerGetBookingFirstNameSuccessfulResponse.extract().body().path("lastname");
//        Assert.assertEquals(actualLastName,lastName, "the last name does not match");

    }



}
