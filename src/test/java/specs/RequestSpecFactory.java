package specs;

import core.ConfigReader;
import core.TokenManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {
    static ConfigReader config = new ConfigReader();
    static String baseUri = config.getBaseUrl();

    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    public static RequestSpecification getAuthSpec(){
        return new RequestSpecBuilder()
                .addRequestSpecification(getBaseSpec())
                .addCookie("token", TokenManager.getToken())
                .build();
    }
}
