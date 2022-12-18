package courier;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class CourierAssertions {

    public void createdSuccess(ValidatableResponse response){
        response.assertThat()
                .statusCode(201)
                .body("ok", is(true))
        ;
    }
    public String createdFailed(ValidatableResponse response){
        return response.assertThat()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .extract()
                .path("message")


                ;
    }

    public String createdConflict(ValidatableResponse response){
        return response.assertThat()
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."))
                .extract()
                .path("message")


                ;
    }
    public int loginSuccess(ValidatableResponse response){
        return response.assertThat()
                .statusCode(200)
                .body("id", greaterThan(0))
                .extract()
                .path("id")
        ;
    }

    public void deletedSuccess(ValidatableResponse response){
        response.assertThat()
                .statusCode(200)
                .body("ok", is(true))
        ;
    }
}
