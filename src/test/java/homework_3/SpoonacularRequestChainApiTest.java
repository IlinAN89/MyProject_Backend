package homework_3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularRequestChainApiTest extends AbstractTest {

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void mealPlanTest() {
        String id = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", "5ded3b38886d391babc5b0a2451ad509768cfb11")
                .body("{\n"
                        + " \"date\": 1644881179,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .log().uri()
                .when()
                .post("https://api.spoonacular.com/mealplanner/antil_anton_73/items")
                .then()
                .statusCode(200)
                .log().status()
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", "5ded3b38886d391babc5b0a2451ad509768cfb11")
                .queryParam("apiKey", getApiKey())
                .log().uri()
                .delete("https://api.spoonacular.com/mealplanner/antil_anton_73/items/" + id)
                .then()
                .statusCode(200)
                .log().status();
    }
}
