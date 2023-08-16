package com.fachrizal.booklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookListApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookListApplication.class, args);
    }

}
