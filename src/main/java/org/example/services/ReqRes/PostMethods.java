package org.example.services.ReqRes;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class PostMethods extends GlobalReUsableMethods {

    // Post is to Create Data

    public String createUser = "api/users";
    public String registerSuccessful = "api/register";
    public String logInSuccessful = "api/login";


    @Test
    public void CreateUser() {
        System.out.println("Create a user >>>");
        String jsonPayload = "{\n" +
                "    \"name\": \"Rachid\",\n" +
                "    \"job\": \"SDET\"\n" +
                "}";
                given()
                .body(jsonPayload).when()
                .post(baseURL_reqRes + createUser)
                .then().statusCode(201)
                .body("id", Matchers.notNullValue()) // Validate that the 'id' field exists
                .log().all();
    }

    @Test
    public void userRegisterSuccessful() {
        System.out.println("Register successful >>>");
        String jsonPayload = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

                given()
                .contentType(ContentType.JSON)
                .body(jsonPayload).when()
                .post(baseURL_reqRes + registerSuccessful)
                .then().statusCode(200)
                .body("token", Matchers.notNullValue()) // Validate that the 'token' field exists
                .body("id", Matchers.equalTo(4)) // Validate the 'id' field value
                .log().all();
    }

    @Test
    public void userRegisterUnSuccessful() {
        System.out.println("Register Unsuccessful >>>");
        String jsonPayload = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";

        given().body(jsonPayload).when().post(baseURL_reqRes + registerSuccessful).then().statusCode(400).log().all();
    }

    @Test
    public void logInSuccessful() {
        System.out.println("LogIn successful >>>");

        String payload = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
                given()
                .contentType(JSON)
                .body(payload)
                .when().post("https://reqres.in/api/register")
                .then()
                .statusCode(200) // Replace with the expected status code
                .log().all(); // Optional: Log the response details;
    }

    @Test
    public void logInWithCorrectCredentials() {
        System.out.println("LogIn successful >>>");
        String payload = "{\"email\":\"eve.holt@reqres.in\",\"password\":\"pistol\"}";
                given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(baseURL_reqRes + logInSuccessful)
                .then()
                .statusCode(200) // Replace with the expected status code
                .body("token", Matchers.notNullValue()) // Validate that the 'token' field exists
//                .body("id", Matchers.equalTo(4)) // Validate the 'id' field value
                .log().all();
    }


}

