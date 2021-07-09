package restAssuredTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DemoGetRequest {

    @Test
    public void getListOfUsersAPITest() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()

                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .assertThat().body("page", equalTo(2))
                .assertThat().body("data[0].id", equalTo(7))
                .assertThat().body("data[0].first_name", equalTo("Michael"))
                .assertThat().body("data[5].last_name", equalTo("Howell"))
                .assertThat().body("data[5].email", equalTo("rachel.howell@reqres.in"))
                .log().all();

    }
}
