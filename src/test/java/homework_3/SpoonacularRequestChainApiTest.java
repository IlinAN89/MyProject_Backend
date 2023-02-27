package homework_3;

import org.junit.jupiter.api.Test;
import service.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SpoonacularRequestChainApiTest extends AbstractTest {

    File addMealReq = new File("src/main/resources/addMealReq.json");

    @Test
    void addMealTest() {
        String id = given()
                .spec(getRequestSpecification())
                .queryParam("hash", getHash())
                .body(addMealReq)
                .when()
                .post(Endpoints.mealPlan)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .spec(getRequestSpecification())
                .queryParam("hash", getHash())
                .delete(Endpoints.mealPlan + id)
                .then()
                .spec(getResponseSpecification());
    }
}
