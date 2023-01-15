package courier;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;


public class CreateCourierTest {

    protected final CourierGenerator generator = new CourierGenerator();
    private final CourierClient client = new CourierClient();
    private final CourierAssertions check = new CourierAssertions();
    private int courierId;

    @After
    public void deleteCourier() {
        if (courierId > 0)
            client.delete(courierId);
        //check.deletedSuccess(courierId);

    }

    @Test
    @DisplayName("Создание курьера")
    public void courierTest() {
        var courier = generator.random();
        ValidatableResponse creatioResponse = client.createCourier(courier);
        check.createdSuccess(creatioResponse);

        Credentials credentials = Credentials.loginfrom(courier);
        ValidatableResponse loginResponse = client.loginCourier(credentials);
        courierId = check.loginSuccess(loginResponse);

    }

    @Test
    @DisplayName("Создание курьера без поля firstname")
    public void courierWithoutFirstnameTest() {
        var courier = generator.random();
        courier.setFirstname(null);

        ValidatableResponse creatioResponse = client.createCourier(courier);
        check.createdSuccess(creatioResponse);
    }

    @Test
    @DisplayName("Создание курьера без поля password")
    public void courierPasswordFailTest() {
        var courier = generator.random();
        courier.setPassword(null);

        ValidatableResponse creatioResponse = client.createCourier(courier);
        String message = check.createdFailed(creatioResponse);
        assert !message.isBlank();
    }

    @Test
    @DisplayName("Авторизация курьера без поля login")
    public void courierLoginFailTest() {
        var courier = generator.random();
        courier.setLogin(null);

        ValidatableResponse creatioResponse = client.createCourier(courier);
        String message = check.createdFailed(creatioResponse);
        assert !message.isBlank();
    }

    @Test
    @DisplayName("Создание курьера с полем login который уже есть в системе")
    public void courierSameLoginFailTest() {
        var courier = generator.random();
        courier.setLogin("oxGL5оEvtY9Z");

        ValidatableResponse creatioResponse = client.createCourier(courier);
        String message = check.createdConflict(creatioResponse);
        assert !message.isBlank();
    }

}


