package org.example.services.RestfulBooker;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

import java.io.File;

public class RestfulBookerCreateNewBooking extends GlobalReUsableMethods {
    public static ValidatableResponse restfulBookerCreateNewBookingSuccessfulResponse;
    public final String create_New_Booking_EndPoint = readRestfulBookerApiEndPointsProperties.getProperty("CreateBooking");
    File payLoad = new File("src/main/resources/payload/RestfulBooker_CreateNewBooking_PayLoad.json");
    public ValidatableResponse restfulBookerCreateNewBookingSuccessful(){
        return post_Request(payLoad,baseURL_RestfulBooker,create_New_Booking_EndPoint);
    }


}
