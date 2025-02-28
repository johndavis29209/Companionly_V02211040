package com.companionly.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.companionly.prototype"})
@EnableJpaRepositories(basePackages = {"com.companionly.prototype"})
@EntityScan(basePackages = {"com.companionly.prototype"})
public class Topic41Application {
    public static void main(String[] args) {
        SpringApplication.run(Topic41Application.class, args);
    }
}
