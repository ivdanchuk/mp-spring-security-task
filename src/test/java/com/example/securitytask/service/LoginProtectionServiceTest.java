package com.example.securitytask.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest("LoginProtectionService.class")
class LoginProtectionServiceTest {
    @Autowired
    LoginProtectionService loginProtectionService;

    @Test
    void succeededLoginShouldResetFailedAttemts() {
        loginProtectionService.failedLogin("test@me.com");
        loginProtectionService.failedLogin("test@me.com");
        loginProtectionService.succeededLogin("test@me.com");
        loginProtectionService.failedLogin("test@me.com");
        assertThat(loginProtectionService.blocked("test@me.com")).isFalse();
    }

    @Test
    void notBlockUserAfterLessThenThreeFailedAttempts() throws InterruptedException {
        loginProtectionService.failedLogin("test@me.com");
        loginProtectionService.failedLogin("test@me.com");
        assertThat(loginProtectionService.blocked("test@me.com")).isFalse();
    }

    @Test
    void blockUserAfterThreeFailedAttempts() throws InterruptedException {
        loginProtectionService.failedLogin("test@me.com");
        loginProtectionService.failedLogin("test@me.com");
        loginProtectionService.failedLogin("test@me.com");
        assertThat(loginProtectionService.blocked("test@me.com")).isTrue();
        Thread thread = Thread.currentThread();
        thread.sleep(10001);
        assertThat(loginProtectionService.blocked("test@me.com")).isFalse();
    }
}