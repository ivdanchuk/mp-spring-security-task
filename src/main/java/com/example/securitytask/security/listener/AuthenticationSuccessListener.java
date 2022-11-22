package com.example.securitytask.security.listener;


import com.example.securitytask.service.LoginProtectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final LoginProtectionService loginProtectionService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String userName = ((UsernamePasswordAuthenticationToken) event.getSource()).getName();
        loginProtectionService.succeededLogin(userName);
    }
}
