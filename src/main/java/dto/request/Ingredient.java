package dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Generated("jsonschema2pojo")
@Data
public class Ingredient {

    @JsonProperty("name")
    public String name;

}
