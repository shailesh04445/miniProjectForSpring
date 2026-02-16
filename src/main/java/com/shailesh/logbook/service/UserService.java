package com.shailesh.logbook.service;
import com.shailesh.logbook.entity.User;

import com.shailesh.logbook.exception.UserAlreadyExistsException;
import com.shailesh.logbook.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder PasswordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder PasswordEncoder) {
        this.userRepository = userRepository;
        this.PasswordEncoder = PasswordEncoder;
    }

    public User create(User user) {

        //check for username uniqueness
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new UserAlreadyExistsException("Username Already Exists");
        }

        if(userRepository.findByEmployeeId(user.getEmployeeId()).isPresent()){
            throw new UserAlreadyExistsException("Employee ID Already Exists");
        }
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
