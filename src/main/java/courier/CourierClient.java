package courier;

import common.Client;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;


public class CourierClient extends Client {

    protected final String ROOT = "/courier";

    @Step("Создание курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all();

    }

    @Step("Авторизация курьера")
    public ValidatableResponse loginCourier(Credentials credentials) {
        return spec()
                .body(credentials)
                .when()
                .post(ROOT + "/login")
                .then().log().all();

    }

    @Step("Удаление созданного курьера")
    public void delete(int courierId) {
        String json = String.format("{\"id\": \"%d\"}", courierId);
        spec()
                .body(json)
                .when()
                .delete(ROOT + "/" + courierId)
                .then().log().all();

    }

}