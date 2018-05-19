package pl.arekn.oregano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("pl.arekn.oregano.*")
//@EnableJpaAuditing
public class OreganoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OreganoApplication.class, args);
    }
}
