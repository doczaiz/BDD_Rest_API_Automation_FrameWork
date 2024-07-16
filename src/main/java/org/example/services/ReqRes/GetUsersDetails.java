package org.example.services.ReqRes;

import org.example.configaration.common.GlobalReUsableMethods;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsersDetails extends GlobalReUsableMethods {
    public String GET_LIST_USERS="api/users";
    public String DELETE_LIST_USERS="api/users/926";
    public String CREATE_USER="api/users";



    @Test
    public void getUser(){
      //  given().when().then();
      //  given().when().get("https://reqres.in/api/users").then().statusCode(200);
        given().when().get(baseURL_reqRes+GET_LIST_USERS).then().statusCode(200).log().all();

    }

    @Test
    public void deleteUser(){
        //  given().when().then();
        //  given().when().get("https://reqres.in/api/users").then().statusCode(200);
        given().when().delete(baseURL_reqRes+DELETE_LIST_USERS).then().statusCode(204);

    }
 @Test
    public void createUser(){
        String jsonPayload="{\n" +
                "    \"name\": \"mahmud\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        //  given().when().then();
        //  given().when().get("https://reqres.in/api/users").then().statusCode(200);
        given().body(jsonPayload).when().post(baseURL_reqRes+CREATE_USER).then().statusCode(201).log().all();

    }


}
