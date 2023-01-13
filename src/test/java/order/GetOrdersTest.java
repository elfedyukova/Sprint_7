package order;

import common.Client;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;


public class GetOrdersTest extends Client {

    private final OrderClient client = new OrderClient();
    private final OrderAssertions check = new OrderAssertions();


    @Test
    @DisplayName("Получение списка заказов")
    public void GetOrdersTest() {
        ValidatableResponse orderResponse = client.getOrders();
        check.getOrderSuccess(orderResponse)
        ;

    }


}
