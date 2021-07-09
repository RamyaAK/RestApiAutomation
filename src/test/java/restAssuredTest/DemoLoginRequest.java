package restAssuredTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DemoLoginRequest {

    HashMap<String, String> map = new HashMap<>();
    String email;
    String password;

    @BeforeTest
    public void prepareTestData() {

        map.put("email", "eve.holt@reqres.in");
        email = map.get("email");
        map.put("password", "cityslicka");
        password = map.get("password");
    }

    @Test
    public void testLoginSuccessful() {

        Response response = given()
                .contentType("application/json")
                .body(map)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .log().all()
                .extract().response();

        String stringAPIResponse = response.asString();
        System.out.println(stringAPIResponse);

        Assert.assertNotNull(response.getBody().equals("token"));
        Assert.assertEquals(response.getBody().jsonPath().getString("token"), "QpwL5tke4Pnpja7X4");


    }
}
