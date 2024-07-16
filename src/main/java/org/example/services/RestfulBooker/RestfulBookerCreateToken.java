package org.example.services.RestfulBooker;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

import java.io.File;

public class RestfulBookerCreateToken extends GlobalReUsableMethods {
    public static ValidatableResponse createTokenSuccessfulResponse;
    public static ValidatableResponse createTokenUnSuccessfulResponse;
    public final String restfulBooker_CreateToken_EndPoint = readRestfulBookerApiEndPointsProperties.getProperty("CreateToken");
    File createToken_PayLoad = new File("src/main/resources/payload/RestfulBooker_CreateToken.json");
    public String testUrl = baseURL_RestfulBooker+restfulBooker_CreateToken_EndPoint;
    public ValidatableResponse createTokenSuccessful(){
        return post_Request(createToken_PayLoad,baseURL_RestfulBooker,restfulBooker_CreateToken_EndPoint,"application/json");
    }

    public ValidatableResponse post_Request(File payload, String baseUrl, String endPoint, String contentType) {
        return requestSpecification.body(payload).contentType(contentType).when()
                .post(baseUrl + endPoint).then();
    }

//    @DataProvider(name = "invalidCredentials")
    public Object[][] createInvalidCredentials() {
        return new Object[][]{
                {"", ""},               // No credentials
                {"wrongUser", "wrongPass"} // Invalid credentials
        };
    }
//    @Test(dataProvider = "invalidCredentials")
    public ValidatableResponse testInvalidTokenCreation(String username, String password){
        String payload = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);
        return post_RequestWithStringPayload(payload,baseURL_RestfulBooker,restfulBooker_CreateToken_EndPoint);

    }
    public ValidatableResponse post_RequestWithStringPayload(String payload, String baseUrl, String endPoint) {
        return requestSpecification.body(payload).contentType("application/json").when()
                .post(baseUrl + endPoint).then();
    }

}
