package ro.nexttech.internship.controller;

import org.springframework.web.bind.annotation.*;
import ro.nexttech.internship.service.UserService;
import ro.nexttech.internship.model.User;
import ro.nexttech.internship.model.UserDto;

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
    List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    UserDto addUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    Optional<UserDto> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    UserDto deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
