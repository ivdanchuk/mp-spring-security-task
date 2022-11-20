package com.example.securitytask.service;

import com.example.securitytask.dto.SignupDTO;
import com.example.securitytask.model.User;
import com.example.securitytask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public void signUp(SignupDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new BadCredentialsException(String.format("User with email %s already exist", dto.getEmail()));
        }

        User newUser = User.builder()
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .enabled((byte) 1)
                .build();

        userRepository.save(newUser);
    }
}
