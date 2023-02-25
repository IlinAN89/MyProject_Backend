package homework_3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SpoonacularPostApiTest extends AbstractTest {

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void postClassifyCuisineMediterraneanTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Pork roast with green beans")
                .formParam("ingredientList", "3 oz pork shoulder")
                .log().uri()
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is("Mediterranean"))
                .log().status();
    }

    @Test
    void postClassifyCuisineIndianTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Curry")
                .formParam("ingredientList", "14 ounce canned unsweetened coconut milk")
                .log().uri()
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is("Indian"))
                .log().status();
    }

    @Test
    void postClassifyCuisineMexicanTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Salsa")
                .formParam("ingredientList", "1 cup papaya")
                .log().uri()
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is("Mexican"))
                .log().status();
    }

    @Test
    void postClassifyCuisineVietnameseTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Pho Bo")
                .formParam("ingredientList", "4 handfuls bean sprouts")
                .log().uri()
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is("Vietnamese"))
                .log().status();
    }

    @Test
    void postClassifyCuisineChineseTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "fried rice")
                .formParam("ingredientList", "6 spring onions")
                .log().uri()
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is("Chinese"))
                .log().status();
    }
}
