package com.levdoc.medhapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedHAppApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MedHAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Its work ...");
    }
}
