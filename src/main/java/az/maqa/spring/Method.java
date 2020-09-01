package az.maqa.spring;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class Method {

    private final String url = "http://localhost:8085/graphql";

    public void findAllEmployees() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/graphql");

        String query = "query employeeList {\n" +
                "  findAllEmployees{\n" +
                "    id\n" +
                "    name\n" +
                "    surname\n" +
                "    age \n" +
                "  }\n" +
                "}";

        ResponseEntity<String> response = restTemplate.postForEntity(url, new HttpEntity<>(query, headers), String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        FindAllEmployees employeeList = objectMapper.readValue(response.getBody(), FindAllEmployees.class);

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        for (Employee employee : employeeList.getEmployeeList()) {
            System.out.println("Id: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Surname: " + employee.getSurname());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Job: " + employee.getJob());
        }
    }





    public void findEmployeeById(Long id) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/graphql");

        String query = "query findEmployeeById {\n" +
                "  findEmployeeById(id:" + id + "){\n" +
                "    id\n" +
                "    name\n" +
                "    surname\n" +
                "    age\n" +
                "    job\n" +
                "    salary\n" +
                "    department{\n" +
                "      id\n" +
                "      departmentName\n" +
                "      departmentCode\n" +
                "    }\n" +
                "  }\n" +
                "}";

        ResponseEntity<String> response = restTemplate.postForEntity(url, new HttpEntity<>(query, headers), String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(response.getBody(), Employee.class);

        System.out.println("Id: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Surname: " + employee.getSurname());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Job: " + employee.getJob());
    }
}
