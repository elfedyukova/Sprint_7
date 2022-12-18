package order;

import common.Client;

import io.restassured.response.ValidatableResponse;



public class OrderClient extends Client {


    protected final String ROOT = "/orders";

    public ValidatableResponse getOrders (){
        return spec()
                .when()
                .get(ROOT)
                .then().log().all();

    }
}
