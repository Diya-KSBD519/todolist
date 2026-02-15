package com.tm26.todolist.services.jwt;

import com.tm26.todolist.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository.findFirstByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));
    }

}
