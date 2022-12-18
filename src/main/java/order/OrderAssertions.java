package order;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class OrderAssertions {


    public void createdOrderSucces(ValidatableResponse response){
        response.assertThat()
                .statusCode(201)

        ;
    }
    public String createdOredrFailed(ValidatableResponse response){
        return response.assertThat()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .extract()
                .path("message")


                ;
    }

    public String getOrderSuccess(ValidatableResponse response){
        return response.assertThat()
                .statusCode(200)
                .extract()
                .path("orders")


                ;
    }



}


