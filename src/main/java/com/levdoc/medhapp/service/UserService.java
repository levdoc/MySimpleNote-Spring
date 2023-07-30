package com.levdoc.medhapp.service;

import com.levdoc.medhapp.model.User;
import com.levdoc.medhapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    protected final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

}
