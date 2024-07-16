package org.example.services.ReqRes;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

public class ReqresUpdateUserDetails extends GlobalReUsableMethods {

    public static ValidatableResponse updateUserSuccessfulResponse;
    public static final String update_User_EndPoint = readReqresApiEndPointsProperties.getProperty("UpdateUserEndPoint");

    public ValidatableResponse updateUserSuccessfulWithValidCredentials(String name,String job){
        String payload = "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";

        return requestSpecification.body(payload).contentType("application/json").when()
                .put(baseURL_Reqres + update_User_EndPoint).then();

    }
    public ValidatableResponse updateUserNameSuccessfulWithValidCredentials(String name){
        String payload = "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \"\"\n" +
                "}";

        return requestSpecification.body(payload).contentType("application/json").when()
                .put(baseURL_Reqres + update_User_EndPoint).then();

    }

    public ValidatableResponse updateUserJobSuccessfulWithValidCredentials(String job){
        String payload = "{\n" +
                "    \"name\": \"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";

        return requestSpecification.body(payload).contentType("application/json").when()
                .put(baseURL_Reqres + update_User_EndPoint).then();

    }
}
