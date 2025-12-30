package services;

import core.ConfigReader;
import io.restassured.response.Response;
import specs.RequestSpecFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthService {
    ConfigReader configReader = new ConfigReader();

    public Response generateToken() {

        Map<String, Object> authPayload = new HashMap<>();
        authPayload.put("username", configReader.getUserName());
        authPayload.put("password", configReader.getPassword());

        return given()
                .spec(RequestSpecFactory.getBaseSpec())
                .when()
                .body(authPayload)
                .post("/auth");
    }
}
