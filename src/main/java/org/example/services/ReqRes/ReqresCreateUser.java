package org.example.services.ReqRes;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

import java.io.File;

public class ReqresCreateUser extends GlobalReUsableMethods {

public static ValidatableResponse reqresCreateUserSuccessfulResponse;
public static final String create_User_EndPoint = readReqresApiEndPointsProperties.getProperty("CreateUser");
    File create_UserPayLoad = new File("src/main/resources/payload/CreateUser.json");

public ValidatableResponse createUserSuccessful(){
    return postMethod(create_UserPayLoad,baseURL_reqRes,create_User_EndPoint,"application/json");
}
    public ValidatableResponse postMethod(File payload,String baseUrl, String endPoint, String contentType) {
        return requestSpecification.body(payload).contentType(contentType).when()
                .post(baseUrl + endPoint).then();
    }

}
