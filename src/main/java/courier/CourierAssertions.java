package courier;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class CourierAssertions {

    @Step("Создание курьера")
    public void createdSuccess(ValidatableResponse response) {
        response.assertThat()
                .statusCode(201)
                .body("ok", is(true))
        ;
    }

    @Step("Создание курьера без обязательных полей")
    public String createdFailed(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .extract()
                .path("message")
                ;
    }

    @Step("Создание курьера с логином, который уже есть в системе")
    public String createdConflict(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."))
                .extract()
                .path("message")
                ;
    }

    @Step("Успешный логин курьера")
    public int loginSuccess(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(200)
                .body("id", greaterThan(0))
                .extract()
                .path("id")
                ;
    }

    @Step("Удаление курьера")
    public void deletedSuccess(ValidatableResponse response) {
        response.assertThat().body("message", equalTo("Учетная запись не найдена"))
                .statusCode(404)
        ;
    }

    @Step("Авторизация с неправильным паролем")
    public void loginFailed(ValidatableResponse response) {
        response.assertThat().body("message", equalTo("Учетная запись не найдена"))
                .statusCode(404)
                .contentType(ContentType.JSON)
        ;

    }

    @Step("Авторизация без логина")
    public void loginEmpty(ValidatableResponse response) {
        response.assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .statusCode(400)
                .contentType(ContentType.JSON)
        ;
    }

    @Step("Авторизация без пароля")
    public void passwordEmpty(ValidatableResponse response) {
        response.assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .statusCode(400)
                .contentType(ContentType.JSON)
        ;
    }

    @Step("Авторизация с несуществующим логином")
    public void loginNotFound(ValidatableResponse response) {
        response.assertThat().body("message", equalTo("Учетная запись не найдена"))
                .statusCode(404)
                .contentType(ContentType.JSON)
        ;
    }

}
