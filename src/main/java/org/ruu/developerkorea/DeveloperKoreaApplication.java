package org.ruu.developerkorea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DeveloperKoreaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeveloperKoreaApplication.class, args);
    }

}
