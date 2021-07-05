package restAssuredTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class GetListOfResourcesRequest {

    @Test
    public void getListOfResourcesTest(){
        given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .log().all()
                .assertThat().body("data.name",hasItems("cerulean","fuchsia rose","true red","aqua sky","tigerlily","blue turquoise"));
    }
}
