package restAssuredTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoDelayedResponseRequest {

    @Test
    public void testDelayedResponseRequest() {

       Response response =given()
                .request().queryParam("delay", "3")
                .when()
                .get("https://reqres.in/api/user")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .log().all()
               .extract().response();

       Assert.assertEquals(response.getBody().jsonPath().getString("support.url"),"https://reqres.in/#support-heading");
    }
}
