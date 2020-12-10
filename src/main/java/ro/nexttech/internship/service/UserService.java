package ro.nexttech.internship.service;

import org.springframework.stereotype.Service;
import ro.nexttech.internship.model.User;
import ro.nexttech.internship.model.UserDto;
import ro.nexttech.internship.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto userDto) {
        userRepository.save(mapToUserEntity(userDto));
        return userDto;
    }

    public Optional<UserDto> getUserById(int id) {
        return Optional.of(mapToUserDto(userRepository.findById(id).orElse(null)));
    }

    public User updateUser(int id, User user) {
        Optional<User> existUser = userRepository.findById(id);
        if (existUser.isPresent()) {
            userRepository.delete(userRepository.getOne(id));
            userRepository.save(user);
        }
        return userRepository.findById(user.getId()).orElse(null);
    }

    public UserDto deleteUser(int id) {
        Optional<User> existUser = userRepository.findById(id);
        existUser.ifPresent(user -> userRepository.delete(user));
        return existUser.map(this::mapToUserDto).orElse(null);
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private User mapToUserEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getPassword());
        return user;
    }


}
