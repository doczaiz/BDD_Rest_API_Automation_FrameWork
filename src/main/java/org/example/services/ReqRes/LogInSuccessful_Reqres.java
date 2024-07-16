package org.example.services.ReqRes;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

import static org.example.configaration.common.RestAPITestBase.readReqresApiEndPointsProperties;

public class LogInSuccessful_Reqres extends GlobalReUsableMethods {

    public static ValidatableResponse loginSuccessfulResponse;
    public static final String LoginEndPoint = readReqresApiEndPointsProperties.getProperty("LoginEndPoint");



    public ValidatableResponse logInSuccessfulWithValidCredentials(String email,String password){

        String loginPayload = "{\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}";

        return requestSpecification.body(loginPayload).contentType("application/json").when()
                .post(baseURL_Reqres + LoginEndPoint).then();

    }
}
