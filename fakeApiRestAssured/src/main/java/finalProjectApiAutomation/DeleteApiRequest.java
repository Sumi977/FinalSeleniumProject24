package finalProjectApiAutomation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class DeleteApiRequest {
    private String urlDeleteSpecificUser = "https://fakerestapi.azurewebsites.net/api/v1/Users/20";

    @Test
    public void deleteRequestMethod(){
      given()
              .when()
              .delete(urlDeleteSpecificUser)
              .then()
              .statusCode(200);
    }

    @Test
    public void verifySpecificUserDeleted(){
        given()
                .when()
                .delete(urlDeleteSpecificUser)
                .then()
                .statusCode(200)
                .log()
                .body();
    }

}
