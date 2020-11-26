package ro.nexttech.internship.user.service;

import org.springframework.stereotype.Service;
import ro.nexttech.internship.user.model.User;
import ro.nexttech.internship.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public List<User> createUser(User user) {
        repository.save(user);
        return getAllUsers();
    }

    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(repository.findById(id).orElse(null));
    }

    public User updateUser(int id, User user) {
        Optional<User> existUser = repository.findById(id);
        if (existUser.isPresent()) {
            repository.delete(repository.getOne(id));
            repository.save(user);
        }
        return repository.findById(user.getId()).orElse(null);
    }

    public User deleteUser(int id) {
        Optional<User> existUser = getUserById(id);
        if (existUser.isPresent())
            repository.deleteById(id);
        return existUser.orElse(null);
    }

}
