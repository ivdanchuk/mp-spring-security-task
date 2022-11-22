package com.example.securitytask.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class LoginProtectionService {
    private final long USER_BLOCKING_TIME_IN_MILLIS = 10000;
    private final int USER_LOGIN_ATTEMPTS = 3;
    private final Map<String,Integer> userLoginAttempts = new HashMap<>();
    private final Map<String, LocalDateTime> blockedUsers = new HashMap<>();

    public void succeededLogin(String key){
        userLoginAttempts.remove(key);
    }

    public void failedLogin(String key){
        Integer attempts = userLoginAttempts.get(key);
        if (attempts==null){
            attempts = 0;
        }
        attempts ++;

        if (attempts >= USER_LOGIN_ATTEMPTS){
            blockLogin(key);
        }else {
            userLoginAttempts.put(key, attempts);
        }
    }

    public void blockLogin(String key){
        blockedUsers.put(key, LocalDateTime.now());
        userLoginAttempts.remove(key);
    }
    public void unblockLogin(String key){
        blockedUsers.remove(key);
    }

    public void checkLogin (String key){
        LocalDateTime blockedTime = blockedUsers.get(key);
        if (blockedTime == null) {
            return;
        }
        long diff =  ChronoUnit.MILLIS.between(blockedTime, LocalDateTime.now());
        if (diff > USER_BLOCKING_TIME_IN_MILLIS){
            unblockLogin(key);
        }
    }
    public Boolean blocked (String key){
        checkLogin(key);
        return blockedUsers.containsKey(key);
    }
}
