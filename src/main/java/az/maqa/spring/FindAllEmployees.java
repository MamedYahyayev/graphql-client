package az.maqa.spring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FindAllEmployees {

    @JsonProperty("findAllEmployees")
    private List<Employee> employeeList;

    @JsonIgnoreProperties
    private Data data;

}
