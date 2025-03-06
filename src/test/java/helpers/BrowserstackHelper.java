package helpers;

import static drivers.BrowserstackDriver.BROWERSTACK_CONFIG;
import static io.restassured.RestAssured.given;

public class BrowserstackHelper {

    public static String getBrowserstackVideoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic(BROWERSTACK_CONFIG.getProfileLogin(), BROWERSTACK_CONFIG.getProfilePassword())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}