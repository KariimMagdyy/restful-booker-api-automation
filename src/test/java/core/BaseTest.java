package core;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.defaultParser = Parser.JSON;
        TokenManager.resetToken();
    }
}
