package youCaterApi.youCaterApi;


import static io.restassured.RestAssured.given;
import youCaterApi.youCaterApi.EndPoints;
import youCaterApi.youCaterApi.UrlConfiguration;
import youCaterApi.utils.*;
import org.testng.annotations.Test;

public class LogoutAPI {

    @Test (description = "Logout: Verify logout funtionality")
    public void testLogout() {
    	
        UrlConfiguration.v1();
        String refreshToken = Authentication.getRefreshToken();

        given().header("Authorization", "Bearer " + refreshToken)
            .contentType("application/json")
            .when().post(EndPoints.LOGOUT)
            .then().log().all().statusCode(200);

        Authentication.clearTokens();
    }
}