package homework_5;

import com.github.javafaker.Faker;
import homework_5.api.ProductService;
import homework_5.dto.ProductResponse;
import homework_5.utils.RetrofitUtils;
import org.junit.jupiter.api.BeforeAll;

import static homework_5.enums.Category.FOOD;

public class BaseTest {
    static ProductService productService;
    static ProductResponse product;
    static Faker faker = new Faker();
    static int id;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);

        product = new ProductResponse()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle(FOOD.title)
                .withPrice((int) (Math.random() * 10000));
    }
}

