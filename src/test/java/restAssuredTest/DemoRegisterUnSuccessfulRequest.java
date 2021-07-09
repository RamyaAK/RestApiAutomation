package restAssuredTest;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DemoRegisterUnSuccessfulRequest {
    HashMap<String, String> map = new HashMap<>();
    String email;

    @BeforeTest
    public void prepareTestData() {

        map.put("email", RestUtils.getEmailId());
        email = map.get("email");

    }

    @Test
    public void testRegisterRequestUnSuccessful() {


        // register attempt without any password in request body should give error msg.

        Response response = given()
                .contentType("application/json")
                .body(map)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400)
                .assertThat().body("error", equalTo("Missing password"))
                .log().all()
                .extract().response();

        String stringAPIResponse = response.asString();
        System.out.println(stringAPIResponse);


    }

}
