package az.maqa.spring;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {

    private Long id;

    private String name;

    private String surname;

    private int age;

    private String job;

    private Double salary;
}
