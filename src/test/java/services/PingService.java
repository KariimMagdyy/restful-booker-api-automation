package services;

import io.restassured.response.Response;
import specs.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class PingService {

    RequestSpecFactory specFactory = new RequestSpecFactory();

    public Response healthCheck(){
        // return object of type "Response" after setting the request spec and reaching the service endpoint
        return given().spec(specFactory.getBaseSpec())
                .when()
                .get("/ping");
    }
}
