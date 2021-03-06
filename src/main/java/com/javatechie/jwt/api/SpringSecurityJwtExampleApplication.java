package com.javatechie.jwt.api;

import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

    @Autowired
    private UserRepository repository;

    @Bean
    CommandLineRunner run() {
        return args -> {
            List<User> users = List.of(
                    new User(101, "javatechie", "password", "javatechie@gmail.com"),
                    new User(102, "user1", "pwd1", "user1@gmail.com"),
                    new User(103, "user2", "pwd2", "user2@gmail.com"),
                    new User(104, "user3", "pwd3", "user3@gmail.com")
            );
            repository.saveAll(users);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
