package order;

import common.Client;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetOrdersTest extends Client {

    private final OrderClient client = new OrderClient();
    private  final OrderAssertions check = new OrderAssertions();

    @Before
    public void setUP () {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }

    @Test
    @Description("Проверка ответа, 200 ок")
    public void GetOrderTest (){
        given()
                .get("/api/v1/orders")
                .then().assertThat().body("orders", not(emptyArray()))
                .statusCode(200)
                .contentType(ContentType.JSON)

        ;



    }

}
