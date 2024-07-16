package stepDefinitions;

import org.example.services.RestfulBooker.RestfulBookerCreateNewBooking;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static org.example.services.RestfulBooker.RestfulBookerCreateNewBooking.restfulBookerCreateNewBookingSuccessfulResponse;

public class RestfulBookerCreateNewBooking_StepDef {
    RestfulBookerCreateNewBooking restfulBookerCreateNewBooking;

    @Given("the API endpoint for creating a new booking")
    public void the_api_endpoint_for_creating_a_new_booking() {
        restfulBookerCreateNewBooking = new RestfulBookerCreateNewBooking();
    }
    @When("I send a Post request to create a new booking")
    public void i_send_a_post_request_to_create_a_new_booking() {
        restfulBookerCreateNewBookingSuccessfulResponse = restfulBookerCreateNewBooking.restfulBookerCreateNewBookingSuccessful();
        restfulBookerCreateNewBookingSuccessfulResponse.log().all();
    }
    @Then("the response status code for create a new booking must be {int}")
    public void the_response_status_code_for_create_a_new_booking_must_be(Integer int1) {
        int actualStatusCode = restfulBookerCreateNewBookingSuccessfulResponse.extract().statusCode();
        Assert.assertEquals(actualStatusCode,int1);
    }

    @And("the response body should contains this deatails:")
    public void theResponseBodyShouldContainsThisDeatails(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        String expectedFirstname = rows.get(0).get("firstname");
        String expectedLastname = rows.get(0).get("lastname");
        String expectedCheckIn = rows.get(0).get("checkIn");
        String expectedCheckout = rows.get(0).get("checkout");

        Assert.assertEquals(restfulBookerCreateNewBookingSuccessfulResponse.extract().jsonPath().getString("booking.firstname"), expectedFirstname, "Firstname does not match.");
        Assert.assertEquals(restfulBookerCreateNewBookingSuccessfulResponse.extract().jsonPath().getString("booking.lastname"), expectedLastname, "Lastname does not match.");
        Assert.assertEquals(restfulBookerCreateNewBookingSuccessfulResponse.extract().jsonPath().getString("booking.bookingdates.checkin"), expectedCheckIn, "Checkin date does not match.");
        Assert.assertEquals(restfulBookerCreateNewBookingSuccessfulResponse.extract().jsonPath().getString("booking.bookingdates.checkout"), expectedCheckout, "Checkout date does not match.");

    }
}
