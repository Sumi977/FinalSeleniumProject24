package finalProjectApiAutomation;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostApiRequest {
    public  String urlPostRequest = "https://fakerestapi.azurewebsites.net/api/v1/Users";
    public  String contentType ="application/json";
    public  Map<String,String> payload = null;


    @Test
    public void createNewUserApiRequest(){
        payload = new HashMap<String,String>();
        payload.put("id","4");
        payload.put("userName","firstName");
        payload.put("password","lastName");
        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200);
    }
    @Test
    public void createNewUserApiRequestWithResponse(){
        payload = new HashMap<String,String>();
        payload.put("id","4");
        payload.put("userName","firstName");
        payload.put("password","lastName");
        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200)
                .log()
                .body();
    }
    @Test
    public void createNewUserApiRequestAndVerifyResponse(){
        payload = new HashMap<String,String>();
        payload.put("id","4");
        payload.put("userName","firstName");
        payload.put("password","lastName");
        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("userName",equalTo("firstName"));
    }
}