package ro.nexttech.internship.user.controller;

import org.springframework.web.bind.annotation.*;
import ro.nexttech.internship.user.model.User;
import ro.nexttech.internship.user.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    List<User> addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    User deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
