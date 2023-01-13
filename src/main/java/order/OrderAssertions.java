package order;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class OrderAssertions {

    @Step("Создание заказа")
    public void createdOrderSuccess(ValidatableResponse response) {
        response.assertThat()
                .statusCode(201)
                .body("track", greaterThan(0))
                .contentType(ContentType.JSON)
        ;
    }

    @Step("Создание заказа с ошибкой")
    public String createdOrderFailed(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(404)
                .body("message", equalTo("Not Found."))
                .extract()
                .path("message")
                ;
    }

    @Step("Получение списка заказов")
    public void getOrderSuccess(ValidatableResponse response) {
        response.assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("orders", not(emptyArray()))

        ;
    }
}


