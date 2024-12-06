package app.repositories;

import app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods if needed
    User findByEmail(String email);  // Example: Find User by email
}