package org.example.services.RestfulBooker;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class RestfulBookerUpdateBooking extends GlobalReUsableMethods {

public static ValidatableResponse restfulBookerUpdateBookingSuccessfulResponse;
public static ValidatableResponse restfulBookerPartialUpdateBookingSuccessfulResponse;
    public final String updateBooking_EndPoint = readRestfulBookerApiEndPointsProperties.getProperty("UpdateBooking");
//    private final String token = "9fd70c0b574fe0a";
//    private final String tokenMethod = createTokenSuccessfulResponse.extract().body().path("token");
    private static final String TOKEN_FILE_PATH = "../BDD-REST_API_Automation_Framework_QE_SUMMER2023/DataTest/tokenValue.txt";

    public static String readTokenFromFile() {
        String token = null;
        try {
            token = new String(Files.readAllBytes(Paths.get(TOKEN_FILE_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return token;
    }
    public ValidatableResponse restfulBookerUpdateBookingSuccessful(String firstname, String lastname, String checkIn, String checkout){

                String payload = String.format("{\"firstname\":\"%s\",\"lastname\":\"%s\",\"totalprice\":150,\"depositpaid\":false,\"bookingdates\":{\"checkin\":\"%s\",\"checkout\":\"%s\"},\"additionalneeds\":\"Lunch\"}", firstname, lastname, checkIn, checkout);

        return given()
                .contentType("application/json")
                .cookie("token", readTokenFromFile())
                .body(payload)
                .when()
                .put(baseURL_RestfulBooker+updateBooking_EndPoint)
                .then();
    }
    public ValidatableResponse restfulBookerPartialUpdateBookingSuccessful(String firstname, String lastname){

        String patchPayload = String.format("{\"firstname\":\"%s\",\"lastname\":\"%s\"}", firstname, lastname);

        return given()
                .contentType("application/json")
                .cookie("token", readTokenFromFile())
                .body(patchPayload)
                .when()
                .patch(baseURL_RestfulBooker+updateBooking_EndPoint)
                .then();
    }


}
