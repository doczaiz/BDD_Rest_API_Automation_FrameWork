package org.example.services.ReqRes;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

public class ReqresRegisterUserFunctionality extends GlobalReUsableMethods {
    public static ValidatableResponse registerUserSuccessfulResponse;
    public static final String register_User_EndPoint = readReqresApiEndPointsProperties.getProperty("RegisterUserEndPoint");
    public ValidatableResponse registerUserSuccessfulWithValidCredentials(String email,String password){
        String payload = "{\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}";

        return requestSpecification.body(payload).contentType("application/json").when()
                .post(baseURL_Reqres + register_User_EndPoint).then();

    }
}
