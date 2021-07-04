package restAssuredTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoDeleteRequest {

    @Test
    public void deleteRequestTest(){

        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .statusLine("HTTP/1.1 204 No Content");
    }
}
