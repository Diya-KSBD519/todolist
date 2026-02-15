package com.tm26.todolist.services.jwt.auth;

import com.tm26.todolist.entities.User;
import com.tm26.todolist.enums.UserRole;
import com.tm26.todolist.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void createAdminAccount()
    {
        Optional<User> optionalUser = userRepository.findByUserRole(UserRole.ADMIN);
        if(optionalUser.isEmpty())
        {
            User user=new User();
            user.setEmail("diya_admin@.com");
            user.setName("diya");
            user.setPassword(new BCryptPasswordEncoder().encode("diya"));
            user.setUserRole(UserRole.ADMIN);
            userRepository.save(user);
            System.out.println("Admin acc created successfully");
        }
        else{
            System.out.println("Admin acc already exsits");

        }

    }

}
