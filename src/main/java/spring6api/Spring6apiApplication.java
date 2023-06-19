package spring6api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Spring6apiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring6apiApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }

}
