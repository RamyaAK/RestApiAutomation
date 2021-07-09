package restAssuredTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DemoPUTRequest {
    HashMap<String, String> map = new HashMap<>();

    @BeforeTest
    public void prepareTestData() {
        map.put("name", RestUtils.getUpdatedName());
        map.put("job", RestUtils.getUpdatedJob());

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";
    }

    @Test
    public void putRequestTest() {
        Response response = given()
                .contentType("application/json")
                .body(map)

                .when()
                .put()

                .then()
                .log().all()

                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")

                .extract().response();

        String jsonResponse = response.asString();
        Assert.assertEquals(jsonResponse.contains("John"), true);
        Assert.assertEquals(jsonResponse.contains("zion resident"), true);
        Assert.assertNotNull("updatedAt", "Did not create a resource");

    }
}
