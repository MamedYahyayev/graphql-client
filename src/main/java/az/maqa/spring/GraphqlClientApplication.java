package az.maqa.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class GraphqlClientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlClientApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        Method method = new Method();

        System.out.print("Make your choice: 1-Employees List, 2-Specific Employee:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                try {
                    method.findAllEmployees();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                Long id = 5L;
                try {
                    method.findEmployeeById(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GraphqlClientApplication.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
