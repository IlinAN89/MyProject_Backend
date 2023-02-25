package homework_3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SpoonacularGetApiTest extends AbstractTest {

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void getSearchRecipesCuisineTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "italian")
                .log().uri()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log().status();
    }

    @Test
    void getSearchRecipesCuisineDietTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "italian")
                .queryParam("diet", "Gluten Free")
                .log().uri()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log().status();
    }

    @Test
    void getSearchRecipesIgnorePantryInstructionsRequiredTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("ignorePantry", false)
                .queryParam("instructionsRequired", true)
                .log().uri()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log().status();
    }

    @Test
    void getSearchRecipesCuisineIncludeIngredientsTypeTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "italian")
                .queryParam("includeIngredients", "tomato")
                .queryParam("type", "sauce")
                .log().uri()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log().status();
    }

    @Test
    void getSearchRecipesSortDirectionDietMaxReadyTimeTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("sortDirection", "asc")
                .queryParam("diet", "Gluten Free")
                .queryParam("maxReadyTime", 25)
                .log().uri()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log().status();
    }
}
