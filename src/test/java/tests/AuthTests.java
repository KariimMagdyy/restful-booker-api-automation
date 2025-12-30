package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.AuthService;
import services.PingService;
import validators.CommonValidators;

public class AuthTests {
    PingService pingService = new PingService();

    @Test(groups = "Smoke")
    public void pingTest(){
        Response response = pingService.healthCheck();
        CommonValidators.assertStatusCode(response,201);
    }

    @Test(groups = "Smoke")
    public void createTokenTest(){
        Response response = new AuthService().generateToken();
        CommonValidators.assertStatusCode(response,200);
    }

}
