package restAssuredTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DemoPostRequest {

    HashMap<String, String> map = new HashMap<>();

    @BeforeTest
    public void prepareTestData() {
        map.put("name", RestUtils.getName());
        map.put("job", RestUtils.getJob());

        System.out.println(RestUtils.getName());

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";
    }

    @Test
    public void postRequestTest() {
        Response response = given()
                .contentType("application/json")
                .body(map)
                .when()
                .post()
                .then()
                .statusCode(201)
                .statusLine("HTTP/1.1 201 Created")
                .log().all()
                .extract().response();

        String jsonResponse = response.asString();
        Assert.assertEquals(jsonResponse.contains("morpheus"), true);
        Assert.assertEquals(jsonResponse.contains("leader"), true);
        Assert.assertNotNull("createdAt", "Did not create a resource");

    }
}
