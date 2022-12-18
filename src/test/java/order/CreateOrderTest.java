package order;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;


public class CreateOrderTest {

    @Before
    public void setUP () {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/api/v1";
    }


    @Test
    public void orderBlackTests (){
        Order order  = new Order ("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5,"2020-06-06", "Saske, come back to Konoha", Collections.singletonList("BLACK"));
        given()
                .header("Content-type", "application/json")
                .body(order)
                .when()
                .post("/orders")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract()
                .path("track")

        ;
    }

    @Test
    public void orderGreyTests (){
        Order order  = new Order ("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5,"2020-06-06", "Saske, come back to Konoha", Collections.singletonList("GREY"));
        given()
                .header("Content-type", "application/json")
                .body(order)
                .when()
                .post("/orders")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract()
                .path("track")


        ;
    }

    @Test
    public void orderBothTests (){
        Order order  = new Order ("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5,"2020-06-06", "Saske, come back to Konoha", List.of("GREY", "BLACK"));
        given()
                .header("Content-type", "application/json")
                .body(order)
                .when()
                .post("/orders")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract()
                .path("track")


        ;
    }

    @Test
    public void orderWithoutColorTests (){
        Order order  = new Order ("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5,"2020-06-06", "Saske, come back to Konoha", Collections.singletonList(null));
        given()
                .header("Content-type", "application/json")
                .body(order)
                .when()
                .post("/orders")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract()
                .path("track")


        ;
    }
}



