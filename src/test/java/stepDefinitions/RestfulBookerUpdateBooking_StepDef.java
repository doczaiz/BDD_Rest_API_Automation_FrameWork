package stepDefinitions;

import org.example.services.RestfulBooker.RestfulBookerUpdateBooking;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static org.example.services.RestfulBooker.RestfulBookerUpdateBooking.restfulBookerPartialUpdateBookingSuccessfulResponse;
import static org.example.services.RestfulBooker.RestfulBookerUpdateBooking.restfulBookerUpdateBookingSuccessfulResponse;

public class RestfulBookerUpdateBooking_StepDef {
    RestfulBookerUpdateBooking restfulBookerUpdateBooking;
    @Given("the API endpoint for updating a booking")
    public void givenTheApiEndpointForUpdatingABooking() {
        restfulBookerUpdateBooking = new RestfulBookerUpdateBooking();
    }
    @When("I send a Put request to update a booking with {}, {}, {}, and {}")
    public void whenISendAPutRequestToUpdateABooking(String firstname, String lastname, String checkIn, String checkout) {
        restfulBookerUpdateBookingSuccessfulResponse = restfulBookerUpdateBooking.restfulBookerUpdateBookingSuccessful(firstname,lastname,checkIn,checkout);
        restfulBookerUpdateBookingSuccessfulResponse.log().all();
    }
    @Then("the response status code for updating a booking must be 200")
    public void thenTheResponseStatusCodeForUpdatingABookingMustBe200() {
        Assert.assertEquals(restfulBookerUpdateBookingSuccessfulResponse.extract().statusCode(), 200, "Status code is not as expected.");
    }
    @Then("the response body should contain the updated details:")
    public void thenTheResponseBodyShouldContainTheUpdatedDetails(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        String expectedFirstname = rows.get(0).get("firstname");
        String expectedLastname = rows.get(0).get("lastname");
        String expectedCheckIn = rows.get(0).get("checkIn");
        String expectedCheckout = rows.get(0).get("checkout");

        Assert.assertEquals(restfulBookerUpdateBookingSuccessfulResponse.extract().jsonPath().getString("firstname"), expectedFirstname, "Firstname does not match.");
        Assert.assertEquals(restfulBookerUpdateBookingSuccessfulResponse.extract().jsonPath().getString("lastname"), expectedLastname, "Lastname does not match.");
        Assert.assertEquals(restfulBookerUpdateBookingSuccessfulResponse.extract().jsonPath().getString("bookingdates.checkin"), expectedCheckIn, "Checkin date does not match.");
        Assert.assertEquals(restfulBookerUpdateBookingSuccessfulResponse.extract().jsonPath().getString("bookingdates.checkout"), expectedCheckout, "Checkout date does not match.");
    }

    @When("I send a Patch request to update a booking with {} and {}")
    public void iSendAPutRequestToUpdateABookingWith(String firstname, String lastname) {
        restfulBookerPartialUpdateBookingSuccessfulResponse = restfulBookerUpdateBooking.restfulBookerPartialUpdateBookingSuccessful(firstname,lastname);
        restfulBookerPartialUpdateBookingSuccessfulResponse.log().all();
    }

    @And("the response body should contain the partial updated details:")
    public void theResponseBodyShouldContainThePartialUpdatedDetails(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        String expectedFirstname = rows.get(0).get("firstname");
        String expectedLastname = rows.get(0).get("lastname");
        Assert.assertEquals(restfulBookerPartialUpdateBookingSuccessfulResponse.extract().jsonPath().getString("firstname"), expectedFirstname, "Firstname does not match.");
        Assert.assertEquals(restfulBookerPartialUpdateBookingSuccessfulResponse.extract().jsonPath().getString("lastname"), expectedLastname, "Lastname does not match.");

    }
}
