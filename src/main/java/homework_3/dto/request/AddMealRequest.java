package homework_3.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "slot",
    "position",
    "type",
    "value"
})
@Generated("jsonschema2pojo")
@Data
public class AddMealRequest {

    @JsonProperty("date")
    private Integer date;
    @JsonProperty("slot")
    private Integer slot;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private Value value;

}
