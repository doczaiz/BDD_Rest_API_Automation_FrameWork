package org.example.services.ReqRes;

import org.example.configaration.common.GlobalReUsableMethods;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutMethods extends GlobalReUsableMethods {

    // Put Method is to Update Data
    public String update_UserName_Id_2 = "api/users/2";

    @Test
    public void updateUserName(){
        // put method to update user`s name
        String jsonPayload="{\n" +
                "    \"name\": \"Rachid\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        given().body(jsonPayload).when().put(baseURL_reqRes+update_UserName_Id_2).then().statusCode(200).log().all();
//        given().when().get(baseURL_reqRes+update_UserName_Id_2).then().statusCode(200).log().all();
    }
    @Test
    public void updateUserJob(){
        // patch method to update user`s job
        String jsonPayload="{\n" +
                "    \"name\": \"Rachid\",\n" +
                "    \"job\": \"SDET\"\n" +
                "}";
        given().body(jsonPayload).when().patch(baseURL_reqRes+update_UserName_Id_2).then().statusCode(200).log().all();
//        given().when().get(baseURL_reqRes+update_UserName_Id_2).then().statusCode(200).log().all();
    }


}
