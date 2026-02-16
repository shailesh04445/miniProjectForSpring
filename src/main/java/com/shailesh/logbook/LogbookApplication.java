package com.shailesh.logbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LogbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogbookApplication.class, args);

    }
}