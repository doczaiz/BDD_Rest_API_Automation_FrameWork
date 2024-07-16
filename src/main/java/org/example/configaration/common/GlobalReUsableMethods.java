package org.example.configaration.common;


import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class GlobalReUsableMethods extends RestAPITestBase {

    // will create all the methods which we want to reuse in our test automation


    public static RequestSpecification requestSpecification = given().auth().oauth(apiKey, apiSecretKey, accessToken, accessTokenSecret);


    public ValidatableResponse postRequest(String payload, String endPoint, String contentType) {
        return requestSpecification.body(payload).contentType(contentType).when()
                .post(baseURL_twitterIncludingVersion + endPoint).then();
    }
    public ValidatableResponse post_Request(File payload,String baseUrl, String endPoint) {
        return requestSpecification.body(payload).contentType("application/json").when()
                .post(baseUrl + endPoint).then();
    }

    public ValidatableResponse putRequest(String payload, String endPoint, String contentType) {
        return requestSpecification.body(payload).contentType(contentType).when()
                .put(baseURL_twitterIncludingVersion + endPoint).then();
    }

    public ValidatableResponse patchRequest(String payload, String endPoint, String contentType) {
        return requestSpecification.body(payload).contentType(contentType).when()
                .patch(baseURL_twitterIncludingVersion + endPoint).then();
    }

    public ValidatableResponse getRequest(String endPoint) {
        return requestSpecification.when()
                .get(baseURL_twitterIncludingVersion + endPoint).then();
    }

    public ValidatableResponse deleteRequest(String endPoint) {
        return requestSpecification.when()
                .delete(baseURL_twitterIncludingVersion + endPoint).then();
    }

    public static ValidatableResponse deleteRequest(String endPoint, String pathParam, Long id) {
        return requestSpecification.pathParams(pathParam,id)
                .when()
                .delete(baseURL_twitterIncludingVersion + endPoint).then();
    }

//    public ValidatableResponse deleteTweet(long id){
//        return requestSpecification.pathParams("id",id)
//                .when().delete(baseURL_twitterIncludingVersion+DELETE_TWEET_V2_ENDPOINT)
//                .then()
//                .statusCode(200);
//    }


    public ValidatableResponse deleteRequest(String endPoint, String pathParam1,String pathPram1Value, String pathParam2,String pathPram2Value) {
        return requestSpecification.pathParams(pathParam1,pathPram1Value,pathParam2,pathPram2Value).when()
                .delete(baseURL_twitterIncludingVersion + endPoint).then();
    }


    public static String convertToString(String st) {
        String splitString = "";
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }


    public static String getProductList() {
        List<String> productList = new ArrayList<>();
        productList.add("hand Sanitizer");
        productList.add("iphone");
        productList.add("tshirt");
        productList.add("jacket");

        for (String st : productList) {
            // System.out.println(st);
            return st;
        }


        return null;
    }

    public static List<String> getProductListReturn() {
        List<String> productList = new ArrayList<>();
        productList.add("hand Sanitizer");
        productList.add("iphone");
        productList.add("tshirt");
        productList.add("jacket");

        return productList;
    }


}
