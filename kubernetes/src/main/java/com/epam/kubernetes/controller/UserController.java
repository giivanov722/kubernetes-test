package com.epam.kubernetes.controller;

import com.epam.kubernetes.data.entity.UserEntity;
import com.epam.kubernetes.model.User;
import com.epam.kubernetes.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public String create(@RequestBody User user) {
        userRepository.save(new UserEntity(user.getFirstName(), user.getLastName()));

        return "Customer was created";
    }

    @GetMapping("/users")
    public List<User> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = new ArrayList<>();

        for (UserEntity userEntity : userEntities) {
            users.add(new User(userEntity.getFirstName(), userEntity.getLastName(), "v2"));
        }

        return users;
    }

    @GetMapping("/user/{id}")
    public String search(@PathVariable long id) {
        String user = "";

        user = userRepository.findById(id).toString();

        return user;
    }

    @GetMapping("/users/{firstname}")
    public List<User> fetchDataByFirstName(@PathVariable String firstname) {
        List<UserEntity> userEntities = userRepository.findByFirstName(firstname);
        List<User> users = new ArrayList<>();

        for (UserEntity userEntity : userEntities) {
            users.add(new User(userEntity.getFirstName(), userEntity.getLastName(), "v2"));
        }

        return users;
    }

    @PostMapping("user/{id}")
    public String delete(@PathVariable long id) {
        userRepository.deleteById(id);

        return "deleted";
    }
}
