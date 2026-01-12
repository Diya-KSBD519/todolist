package com.tm26.todolist.repositories;

import com.tm26.todolist.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findFirstByEmail(String username);
}
