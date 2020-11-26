package ro.nexttech.internship.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.nexttech.internship.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
