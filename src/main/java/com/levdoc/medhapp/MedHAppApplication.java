package com.levdoc.medhapp;

import com.levdoc.medhapp.model.SimpleNoteModel;
import com.levdoc.medhapp.model.User;
import com.levdoc.medhapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MedHAppApplication implements CommandLineRunner {
    private final UserService userService;

    public MedHAppApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MedHAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Its work ...");

        SimpleNoteModel snm = new SimpleNoteModel(
                "name","simpleTest", LocalDate.now()
        );

        List<SimpleNoteModel> testList = new ArrayList<>();
        testList.add(snm);
        testList.add(snm);
        testList.add(snm);
        testList.add(snm);

        User newUser = new User("test","test","test",
                "password", testList);

        userService.save(newUser);

    }
}
