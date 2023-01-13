package courier;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class DeleteCourierTest {

    protected final CourierGenerator generator = new CourierGenerator();
    private final Credentials credentials = new Credentials();
    private final CourierClient client = new CourierClient();
    private final CourierAssertions check = new CourierAssertions();
    private int courierId;


    @Test
    @DisplayName("Успешное удаление курьера")
    public void testPassMessageDeleteCourier() {
        var courier = generator.random();
        ValidatableResponse creatioResponse = client.createCourier(courier);
        check.createdSuccess(creatioResponse);

        Credentials credentials = Credentials.loginfrom(courier);
        ValidatableResponse loginResponse = client.loginCourier(credentials);
        courierId = check.loginSuccess(loginResponse);
        check.deletedSuccess(loginResponse);
    }
}
