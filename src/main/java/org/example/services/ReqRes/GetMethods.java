package org.example.services.ReqRes;

import org.example.configaration.common.GlobalReUsableMethods;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethods extends GlobalReUsableMethods {

    // Get Method is to Retrieve Data
    public String get_Single_USER="api/users/4";
    public String GET_LIST_USERS="api/users?page=1";
    public String get_Single_USER_Not_Found ="api/users/23";
    public String get_List_Resource = "api/unknown";
    public String get_Single_Resource = "api/unknown/2";
    public String get_Single_Resource_Not_Found = "api/unknown/23";

    @Test
    public void getSingleUser(){
        System.out.println("User Id : 4 Details >>> Test ");
        given().when().get(baseURL_reqRes+get_Single_USER).then().statusCode(200).log().all();
    }

   @Test
   public void getUsersDetails(){
       System.out.println(" Users Details on page 1 >>> Test");
        given().when().get(baseURL_reqRes+GET_LIST_USERS).then().statusCode(200).log().all();
    }
    @Test
    public void getSingleUserNotFound(){
        System.out.println("Get Single not Found >>> Test");
        given().when().get(baseURL_reqRes+ get_Single_USER_Not_Found).then().statusCode(404).log().all();
    }
    @Test
    public void getSingleResourceNotFound(){
        System.out.println("Get Single Resource not Found >>> Test");
        given().when().get(baseURL_reqRes+ get_Single_Resource_Not_Found).then().statusCode(404).log().all();
    }
    @Test
    public void getListResource(){
        System.out.println("Get List Resource >>> Test");
        given().when().get(baseURL_reqRes+get_List_Resource).then().statusCode(200).log().all();
    }
    @Test
    public void getSingleResource(){
        System.out.println("Get Single Resource >>> Test");
        given().when().get(baseURL_reqRes+get_Single_Resource).then().statusCode(200).log().all();
    }

}
