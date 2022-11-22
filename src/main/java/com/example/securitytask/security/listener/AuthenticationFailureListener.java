package com.example.securitytask.security.listener;

import com.example.securitytask.service.LoginProtectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Slf4j
@AllArgsConstructor
@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    private HttpServletRequest request;
    private final LoginProtectionService loginProtectionService;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        String userName = ((UsernamePasswordAuthenticationToken) event.getSource()).getName();
        loginProtectionService.failedLogin(userName);
        log.info(String.format("User %s failed to login", userName));
    }
}
