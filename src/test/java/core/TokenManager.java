package core;

import io.restassured.response.Response;
import services.AuthService;

public class TokenManager {

    private static String token;

    private TokenManager(){
        // private constructor to prevent instantiation
    }

    public static String getToken() {
        if (token == null || token.isBlank()) {
            token = fetchNewToken();
        }
        return token;
    }

    private static String fetchNewToken() {
        Response response = new AuthService().generateToken();

        String newToken = response.jsonPath().getString("token");
        if (newToken == null || newToken.isBlank()) {
            response.then().log().all();
            throw new RuntimeException("Auth response did not contain token");
        }

        return newToken;
    }

    public static void resetToken() {
        token = null;
    }
}
