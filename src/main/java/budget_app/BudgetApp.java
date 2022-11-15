package budget_app;

import budget_app.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BudgetApp {

    public static void main(String[] args) {
        SpringApplication.run(BudgetApp.class);
        User.builder()
                .username("John")
                .password("Smith")
                .id(1L)
                .email("johnsmith@yahoo.com")
                .firstName("John")
                .lastName("Smith")
                .build();
    }
}
