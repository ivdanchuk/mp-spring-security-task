package com.example.securitytask.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BrutForceProtectionService {
    private final Map<String,Integer> userAttemtsCache = new HashMap<>();

}
