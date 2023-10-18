package com.example.http.repository;
import com.example.http.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByPhoneNumber (String sender);
    User getUserByPhoneNumber (String account);

    User getUserById (Long id);
}
