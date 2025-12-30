package core;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeClass
    public void setup() {
        RestAssured.defaultParser = Parser.JSON;

        TokenManager.resetToken();
    }

    @BeforeMethod
    public void resetRestAssured() {
        RestAssured.reset();
    }
}
