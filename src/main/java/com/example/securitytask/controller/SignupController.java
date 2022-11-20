package com.example.securitytask.controller;

import com.example.securitytask.dto.SignupDTO;
import com.example.securitytask.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignupController {
    private final SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupDTO dto){
        signupService.signUp(dto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
