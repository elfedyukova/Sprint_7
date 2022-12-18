package courier;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class LoginCourierTest {

    private final Credentials credentials  = new Credentials();
    protected  final CourierGenerator generator = new CourierGenerator();
    private final CourierClient client = new CourierClient();
    private  final CourierAssertions check = new CourierAssertions();

    @Before
    public void setUP () {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/api/v1";
    }

    @Test
    public void loginFailTest (){

        courier.Credentials credentials = new courier.Credentials("test", "test");
        given()
                .header("Content-type", "application/json")
                .body(credentials)
                .when()
                .post("/courier/login")
                .then().assertThat().body("message", equalTo("Учетная запись не найдена"))
                .statusCode(404)
                .contentType(ContentType.JSON)

        ;

    }

    @Test
    public void loginPassTest (){

        courier.Credentials credentials = new courier.Credentials("6ninja", "1234");
        given()
                .header("Content-type", "application/json")
                .body(credentials)
                .when()
                .post("/courier/login")
                .then()
                .statusCode(200)
                .extract()
                .path("id")

        ;

    }

    @Test
    public void loginWithoutTest (){

        courier.Credentials credentials = new courier.Credentials(null, "test");
        given()
                .header("Content-type", "application/json")
                .body(credentials)
                .when()
                .post("/courier/login")
                .then().assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .statusCode(400)
                .contentType(ContentType.JSON)

        ;

    }

    @Test
    public void passwordWithoutTest (){

        courier.Credentials credentials = new courier.Credentials("6ninja", null);
        given()
                .header("Content-type", "application/json")
                .body(credentials)
                .when()
                .post("/courier/login")
                .then().assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .statusCode(400)
                .contentType(ContentType.JSON)

        ;

    }
    @Test
    public void passwordWrongTest (){

        courier.Credentials credentials = new courier.Credentials("6ninja", "test");
        given()
                .header("Content-type", "application/json")
                .body(credentials)
                .when()
                .post("/courier/login")
                .then().assertThat().body("message", equalTo("Учетная запись не найдена"))
                .statusCode(404)
                .contentType(ContentType.JSON)

        ;

    }

 @Test
    public void ll (){
        var courier = generator.generic();
        Credentials credentials = Credentials.loginfrom(courier);
        ValidatableResponse loginResponse = client.loginCourier(credentials);
        int id = check.loginSuccess(loginResponse);
 }
}
