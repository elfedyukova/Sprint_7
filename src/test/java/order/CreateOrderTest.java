package order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;


public class CreateOrderTest {

    protected final OrderGenerator generator = new OrderGenerator();
    private final OrderClient order = new OrderClient();
    private final OrderAssertions check = new OrderAssertions();

    @Test
    @DisplayName("Успешное создание заказа - черный цвет")
    public void orderBlackTest() {

        var orders = generator.genericBlack();
        ValidatableResponse creatioResponse = order.createOrder(orders);
        check.createdOrderSuccess(creatioResponse)
        ;

    }

    @Test
    @DisplayName("Успешное создание заказа - серый цвет")
    public void orderGreyTest() {

        var orders = generator.genericGrey();
        ValidatableResponse creatioResponse = order.createOrder(orders);
        check.createdOrderSuccess(creatioResponse)
        ;

    }

    @Test
    @DisplayName("Успешное создание заказа - Без цвета")
    public void orderWithoutColorTest() {

        var orders = generator.genericWithoutColor();
        ValidatableResponse creationResponse = order.createOrder(orders);
        check.createdOrderSuccess(creationResponse)
        ;

    }

    @Test
    @DisplayName("Успешное создание заказа - Два цвета")
    public void orderBothTests() {
        var orders = generator.genericGreyBlack();
        ValidatableResponse creationResponse = order.createOrder(orders);
        check.createdOrderSuccess(creationResponse)
        ;

    }

    @Test
    @DisplayName("Успешное создание заказа - colour null")
    public void orderColourNullTests() {
        var orders = generator.genericColourNull();
        ValidatableResponse creationResponse = order.createOrder(orders);
        check.createdOrderSuccess(creationResponse)
        ;
    }

    @Test
    @DisplayName("Заказ с неверным методом")
    public void orderWrongMethodTests() {
        var orders = generator.genericGrey();
        ValidatableResponse creationResponse = order.createOrderPut(orders);
        check.createdOrderFailed(creationResponse)
        ;
    }

}



