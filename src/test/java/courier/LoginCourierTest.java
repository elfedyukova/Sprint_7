package courier;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;


public class LoginCourierTest {

    protected final CourierGenerator generator = new CourierGenerator();
    private final Credentials credentials = new Credentials();
    private final CourierClient client = new CourierClient();
    private final CourierAssertions check = new CourierAssertions();


    @Test
    @DisplayName("Успешная авторизация")
    public void testPassMessageLogin() {
        var courier = generator.generic();
        Credentials credentials = Credentials.loginfrom(courier);
        ValidatableResponse loginResponse = client.loginCourier(credentials);
        check.loginSuccess(loginResponse);
    }

    @Test
    @DisplayName("Авторизация с  несуществующим логином")
    public void testErrorMessageForIncorrectLogin() {
        var courier = generator.generic();
        courier.setLogin("tester999");
        Credentials credentials = Credentials.loginfrom(courier);
        ValidatableResponse loginResponse = client.loginCourier(credentials);
        check.loginNotFound(loginResponse);
    }

    @Test
    @DisplayName("Авторизация с пустым логином")
    public void testErrorMessageForNotFoundLogin() {
        var courier = generator.generic();
        courier.setLogin(null);
        Credentials credentials = Credentials.loginfrom(courier);
        ValidatableResponse loginResponse = client.loginCourier(credentials);
        check.loginEmpty(loginResponse);
    }

    @Test
    @DisplayName("Авторизация с неверным паролем")
    public void testErrorMessageForIncorrectPassword() {
        var courier = generator.generic();
        courier.setPassword("hghf");
        Credentials credentials = Credentials.loginfrom(courier);
        ValidatableResponse loginResponse = client.loginCourier(credentials);
        check.loginFailed(loginResponse);
    }

    @Test
    @DisplayName("Авторизация с пустым паролем")
    public void testErrorMessageForNotFoundPassword() {
        var courier = generator.generic();
        courier.setPassword(null);
        Credentials credentials = Credentials.loginfrom(courier);
        ValidatableResponse loginResponse = client.loginCourier(credentials);
        check.passwordEmpty(loginResponse);
    }

}
