package com.capgemini.genai.clinicaldecision.repository;

import com.capgemini.genai.clinicaldecision.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findByUsernameContaining(String username);
}
