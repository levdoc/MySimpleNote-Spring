package com.levdoc.medhapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedHAppApplication implements CommandLineRunner {

    @Value("${server.port}")
    private String serverPort;

    public static void main(String[] args) {
        SpringApplication.run(MedHAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Its work ...");
        System.out.println("Application path: http://localhost:" + serverPort);
    }
}
