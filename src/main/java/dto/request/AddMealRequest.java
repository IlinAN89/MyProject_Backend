package dto.request;

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
    public Integer date;
    @JsonProperty("slot")
    public Integer slot;
    @JsonProperty("position")
    public Integer position;
    @JsonProperty("type")
    public String type;
    @JsonProperty("value")
    public Value value;

}
