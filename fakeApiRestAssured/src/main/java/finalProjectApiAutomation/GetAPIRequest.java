package finalProjectApiAutomation;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;


public class GetAPIRequest {
    private String urlGetRequest = "https://fakerestapi.azurewebsites.net/api/v1/Users";
    private String urlGetRequestSpecificUserId = "https://fakerestapi.azurewebsites.net/api/v1/Users/2";

    @Test
    public void getRequestFromFakeApi(){
        given()
                .when()
                .get(urlGetRequest)
                .then()
                .statusCode(200)
                .log()
                .body();

    }
    @Test
    public void getRequestFromFakeApiWithSpecificUserId(){
        given()
                .when()
                .get(urlGetRequestSpecificUserId)
                .then()
                .statusCode(200)
                .log()
                .body();


    }

    @Test
    public void verifyIfGetRequestFromFakeApiWithSpecificUserIdExist(){
        given()
                .when()
                .get(urlGetRequestSpecificUserId)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("id",equalTo(2));

    }


}
