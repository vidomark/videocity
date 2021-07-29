package com.codecool.userservice.service;

import com.codecool.userservice.model.SecurityUser;
import com.codecool.userservice.model.User;
import com.codecool.userservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Username %s not found!", username));
        }

        return new SecurityUser(user.get());
    }

    public void registerUser(User user) {
        boolean usernameExists = userRepository
                .findUserByUsername(user.getUsername())
                .isPresent();

        boolean emailExists = userRepository
                .findUserByEmail(user.getEmail())
                .isPresent();

        if (usernameExists || emailExists) {
            throw new IllegalStateException("Username or email already exists!");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
    }
}