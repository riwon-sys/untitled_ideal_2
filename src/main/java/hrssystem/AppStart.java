package hrssystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart { // Spring Boot 애플리케이션의 시작점입니다.
    public static void main(String[] args) {
        // Start the Spring Boot application
        SpringApplication.run(AppStart.class, args);
    }
}
