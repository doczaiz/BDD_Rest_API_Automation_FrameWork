package org.example.services.Twitter;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

import java.io.File;

import static org.example.configaration.common.RestAPITestBase.readApiEndPointsProperties;

public class CreateTweet extends GlobalReUsableMethods {
    public static ValidatableResponse creteTweetSuccessfullyUsingValidAuthenticationResponse;
    public static ValidatableResponse deleteTweetResponse;

    public static final String POST_TWEET = readApiEndPointsProperties.getProperty("POST_TWEET");
    public static final String DELETE_TWEET = readApiEndPointsProperties.getProperty("DELETE_TWEET");


    public ValidatableResponse creteTweetSuccessfullyUsingValidAuthentication() {
        //   System.out.println(baseURL_twitterIncludingVersion+POST_TWEET);
        //   given().when().get(baseURL_reqRes+GET_LIST_USERS).then().statusCode(200).log().all();
        // given().when().body().post().then();
        // JSON Payload: 3-4 Approach

        String tweetPayload = "{\n" +
                "\"text\": \"API Automation test2024-3\"\n" +
                "}\n";

        return requestSpecification.body(tweetPayload).contentType("application/json").when()
                .post(baseURL_twitterIncludingVersion + POST_TWEET).then();

    }

    public ValidatableResponse creteTweetSuccessfullyUsingValidAuthentication2() {

        String tweetPayload = "{\n" +
                "\"text\": \"API Automation test2024-3\"\n" +
                "}\n";

        return postRequest(tweetPayload, POST_TWEET, "application/json");
    }

    public ValidatableResponse creteTweetSuccessfullyUsingValidAuthentication1() {
        //   System.out.println(baseURL_twitterIncludingVersion+POST_TWEET);
        //   given().when().get(baseURL_reqRes+GET_LIST_USERS).then().statusCode(200).log().all();
        // given().when().body().post().then();
        // JSON Payload: 3-4 Approach

        File tweetPayload = new File("src/main/resources/payload/createTweet.json");

        return requestSpecification.body(tweetPayload).contentType("application/json").when()
                .post(baseURL_twitterIncludingVersion + POST_TWEET).then();

    }

    public ValidatableResponse updateTweetSuccessfullyUsingValidAuthentication() {
        //   System.out.println(baseURL_twitterIncludingVersion+POST_TWEET);
        //   given().when().get(baseURL_reqRes+GET_LIST_USERS).then().statusCode(200).log().all();
        // given().when().body().post().then();
        // JSON Payload: 3-4 Approach

        String tweetPayload = "{\n" +
                "\"text\": \"API Automation test2024-3\"\n" +
                "}\n";

        return requestSpecification.body(tweetPayload).contentType("application/json").when()
                .put(baseURL_twitterIncludingVersion + POST_TWEET).then();

    }

    public ValidatableResponse updatePartialTweetSuccessfullyUsingValidAuthentication() {
        //   System.out.println(baseURL_twitterIncludingVersion+POST_TWEET);
        //   given().when().get(baseURL_reqRes+GET_LIST_USERS).then().statusCode(200).log().all();
        // given().when().body().post().then();
        // JSON Payload: 3-4 Approach

        String tweetPayload = "{\n" +
                "\"text\": \"API Automation test2024-3\"\n" +
                "}\n";

        return requestSpecification.body(tweetPayload).contentType("application/json").when()
                .patch(baseURL_twitterIncludingVersion + POST_TWEET).then();

    }


    public ValidatableResponse getTweetSuccessfullyUsingValidAuthentication() {
        return requestSpecification.when()
                .get(baseURL_twitterIncludingVersion + POST_TWEET).then();

    }

    public ValidatableResponse deleteTweet(String pathParam, Long id) {
        return deleteRequest(DELETE_TWEET,pathParam,id);

    }


}
