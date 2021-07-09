package restAssuredTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DemoLoginFailedRequest {

    HashMap<String, String> map = new HashMap<>();


    @BeforeTest
    public void prepareTestData() {
        map.put("email", "eve.holt@reqres.in");
    }

    @Test
    public void testLoginFailed() {

        Response response = given()
                .contentType("application/json")
                .body(map)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(400)
                .statusLine("HTTP/1.1 400 Bad Request")
                .log().all()
                .extract().response();

        String stringAPIResponse = response.asString();
        System.out.println(stringAPIResponse);

        Assert.assertEquals(response.getBody().jsonPath().getString("error"), "Missing password");


    }
}
