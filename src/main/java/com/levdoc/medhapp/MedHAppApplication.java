package com.levdoc.medhapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

import static org.aspectj.util.FileUtil.copyFile;

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


//        File from = new File("src.txt");
//        File to = new File("dest.txt");
//
//        try {
//            copyFile(from, to);
//            System.out.println("File copied successfully.");
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }
}
