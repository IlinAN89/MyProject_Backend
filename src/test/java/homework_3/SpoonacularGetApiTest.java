package homework_3;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import homework_3.service.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class SpoonacularGetApiTest extends AbstractTest {
    private static ResponseSpecification responseGetSpecification;

    @BeforeAll
    static void beforeGetTest() {
        responseGetSpecification = new ResponseSpecBuilder()
                .expectBody("totalResults", notNullValue())
                .expectBody("results[0]", hasKey("id"))
                .expectBody("results[0]", hasKey("title"))
                .build();
        RestAssured.responseSpecification = responseGetSpecification;
    }

    public static ResponseSpecification getResponseGetSpecification() {
        return responseGetSpecification;
    }

    @Test
    void getSearchRecipesCuisineTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("cuisine", "italian")
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchRecipesCuisineDietTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("cuisine", "italian")
                .queryParam("diet", "Gluten Free")
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchRecipesIgnorePantryInstructionsRequiredTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("ignorePantry", false)
                .queryParam("instructionsRequired", true)
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchRecipesCuisineIncludeIngredientsTypeTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("cuisine", "italian")
                .queryParam("includeIngredients", "tomato")
                .queryParam("type", "sauce")
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchRecipesSortDirectionDietMaxReadyTimeTest() {
        given()
                .spec(getRequestSpecification())
                .queryParam("sortDirection", "asc")
                .queryParam("diet", "Gluten Free")
                .queryParam("maxReadyTime", 25)
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }
}
