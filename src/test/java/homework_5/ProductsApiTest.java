package homework_5;

import homework_5.dto.ProductResponse;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static homework_5.enums.Category.FOOD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductsApiTest extends BaseTest {

    @SneakyThrows
    @Test
    void getProductsTest() {
        Response<ResponseBody> response = productService.getProducts().execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(200));
        assertThat(productsMapper.selectByExample(new db.model.ProductsExample()).size(), equalTo(5));
    }

    @SneakyThrows
    @Test
    void createProductTest() {
        Response<ProductResponse> response = productService.createProduct(product).execute();
        id = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(201));
        assertThat(response.body().getId(), equalTo(id));
        assertThat(response.body().getCategoryTitle(), equalTo(FOOD.title));
        assertThat(productsMapper.selectByExample(new db.model.ProductsExample()).size(), equalTo(5));
    }

    @SneakyThrows
    @Test
    void modifyProductTest() {
        Response<ProductResponse> createResponse = productService.createProduct(product).execute();
        int newId = createResponse.body().getId();
        assertThat(createResponse.code(), equalTo(201));

        Response<ProductResponse> modifyResponse = productService.modifyProduct(product
                .withId(newId)
                .withCategoryTitle(faker.food().ingredient())
                .withCategoryTitle(FOOD.title)
                .withPrice((int) (Math.random() * 10000)))
                .execute();
        assertThat(modifyResponse.isSuccessful(), CoreMatchers.is(true));
        assertThat(modifyResponse.code(), equalTo(200));
        assertThat(modifyResponse.body().getId(), equalTo(newId));
        assertThat(modifyResponse.body().getCategoryTitle(), equalTo(FOOD.title));

        Response<ResponseBody> deleteResponse = productService.deleteProduct(newId).execute();
        assertThat(deleteResponse.isSuccessful(), CoreMatchers.is(true));
        assertThat(deleteResponse.code(), equalTo(200));
        assertThat(productsMapper.selectByExample(new db.model.ProductsExample()).size(), equalTo(5));
    }

    @SneakyThrows
    @Test
    void getProductByIdTest() {
        Response<ProductResponse> response = productService.getProductById(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(200));
        assertThat(response.body().getId(), equalTo(id));
        assertThat(response.body().getCategoryTitle(), equalTo(FOOD.title));
        assertThat(productsMapper.selectByExample(new db.model.ProductsExample()).size(), equalTo(5));
    }

    @SneakyThrows
    @AfterAll

    @Test
    static void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(200));
        assertThat(productsMapper.selectByExample(new db.model.ProductsExample()).size(), equalTo(5));
    }
}

