package homework_5.api;

import homework_5.dto.ProductResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ProductService {

    @GET("products")
    Call<ResponseBody> getProducts();

    @POST("products")
    Call<ProductResponse> createProduct(@Body ProductResponse createProductRequestResponse);

    @PUT("products")
    Call<ProductResponse> modifyProduct(@Body ProductResponse modifyProductRequestResponse);

    @GET("products/{id}")
    Call<ProductResponse> getProductById(@Path("id") int id);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);

}
