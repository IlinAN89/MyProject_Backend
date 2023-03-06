package homework_3.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "id"
})

@Data
public class AddMealResponse {

        @JsonProperty("status")
        private String status;
        @JsonProperty("id")
        private Integer id;

}
