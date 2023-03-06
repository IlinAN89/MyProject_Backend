package homework_5;

import homework_5.dto.GetCategoryResponse;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static homework_5.enums.Category.FOOD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetCategoryTest extends BaseTest {

    @SneakyThrows
    @Test
    void getCategoryByIdPositiveTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(FOOD.id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(FOOD.id));
        assertThat(response.body().getTitle(), equalTo(FOOD.title));
                response.body().getProductResponses().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo(FOOD.title)));
        assertThat(categoriesMapper.selectByExample(new db.model.CategoriesExample()).size(), equalTo(2));
    }
}
