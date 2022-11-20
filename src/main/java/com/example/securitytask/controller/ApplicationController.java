package com.example.securitytask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
public class ApplicationController {

    @GetMapping("info")
    public String getInfo (){
        return "Spring Security application task.";
    }

    @GetMapping("about")
    public String getAbout (){
        return "EPAM mentoring program.";
    }

}
