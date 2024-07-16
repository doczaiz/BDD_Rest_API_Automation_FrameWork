package org.example.services.ReqRes;

import org.example.configaration.common.GlobalReUsableMethods;
import io.restassured.response.ValidatableResponse;

public class ReqresRetrieveUserDetails extends GlobalReUsableMethods {

    public static ValidatableResponse retrieveSingleUserDetailsSuccessfulResponse;
    public static ValidatableResponse retrieveListUsersDetailsSuccessfulResponse;
    public static final String retrieve_Single_User_EndPoint = readReqresApiEndPointsProperties.getProperty("RetrieveSingleUserData");
    public static final String retrieve_List_Users_EndPoint = readReqresApiEndPointsProperties.getProperty("RetrieveListUsersData");

    public ValidatableResponse retrieveSingleUserDetailSuccessful(){
        return requestSpecification.when()
                .get(baseURL_reqRes + retrieve_Single_User_EndPoint).then();
    }

    public ValidatableResponse retrieveListUsersDetailsSuccessful(){
        return requestSpecification.when().get(baseURL_reqRes + retrieve_List_Users_EndPoint ).then();
    }

    public String[][] validateData() {
        String[][] expectedData = {
                {"7", "michael.lawson@reqres.in", "Michael", "Lawson", "https://reqres.in/img/faces/7-image.jpg"},
                {"8", "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson", "https://reqres.in/img/faces/8-image.jpg"},
                {"9", "tobias.funke@reqres.in", "Tobias", "Funke", "https://reqres.in/img/faces/9-image.jpg"},
                {"10", "byron.fields@reqres.in", "Byron", "Fields", "https://reqres.in/img/faces/10-image.jpg"},
                {"11", "george.edwards@reqres.in", "George", "Edwards", "https://reqres.in/img/faces/11-image.jpg"},
                {"12", "rachel.howell@reqres.in", "Rachel", "Howell", "https://reqres.in/img/faces/12-image.jpg"}
        };
        return expectedData;
    }
}
