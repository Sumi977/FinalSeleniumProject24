package finalProjectApiAutomation;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutApiRequest {
    public String urlPutRequest = "https://fakerestapi.azurewebsites.net/api/v1/Users/7";
    public String contentType = "application/json";
    public Map<String,String> payload = null;

    @Test
    public void editUserWithPutRequest(){
        payload = new HashMap<String,String>();
        payload.put("id","10");
        payload.put("userName","Janet");
        payload.put("password","johnson");

        given().contentType(contentType).body(payload)
                .when()
                .put(urlPutRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("userName",equalTo("Janet"));



    }

}
