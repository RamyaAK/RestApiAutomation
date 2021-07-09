package restAssuredTest;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DemoRegisterSuccessfulRequestTest {

    HashMap<String, String> map = new HashMap<>();
    String email;
    String password;

    @BeforeTest
    public void prepareTestData() {

        map.put("email", RestUtils.getEmailId());
        email = map.get("email");
        map.put("password", RestUtils.getPassword());
        password = map.get("password");
    }

    @Test
    public void testRegisterRequestSuccessful() {

        Response response = given()
                .contentType("application/json")
                .body(map)
                .when()
                .post("https://reqres.in/api/reg")
                .then()
                .statusCode(201)
                .statusLine("HTTP/1.1 201 Created")
                .assertThat().body("email", equalTo(email))
                .assertThat().body("password",equalTo(password))
                .log().all()
                .extract().response();

        String stringAPIResponse = response.asString();
        System.out.println(stringAPIResponse);


    }
}
