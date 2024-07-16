package org.example.services.RestfulBooker;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

public class RestfulBookerGetBookingIds extends GlobalReUsableMethods {
    public static ValidatableResponse restfulBookerGetBookingIdsSuccessfulResponse;
    public static ValidatableResponse restfulBookerGetBookingFirstNameSuccessfulResponse;
    public final String get_Booking_Ids_EndPoint = readRestfulBookerApiEndPointsProperties.getProperty("GetBookingIds");
    public final String get_Booking_FirstName_EndPoint = readRestfulBookerApiEndPointsProperties.getProperty("GetBooking_FirstName");
    public ValidatableResponse restfulBookerGetBookingIdsSuccessful(){
        return get_Request(get_Booking_Ids_EndPoint);
    }
    public ValidatableResponse get_Request(String endPoint) {
        return requestSpecification.when()
                .get(baseURL_RestfulBooker + endPoint).then();
    }
    public ValidatableResponse restfulBookerGetBookingFirstNameAndLastNameSuccessful(Integer Id){
        return get_Request(get_Booking_FirstName_EndPoint+Id);
    }
}
