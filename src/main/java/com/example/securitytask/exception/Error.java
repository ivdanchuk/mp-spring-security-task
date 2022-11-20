package com.example.securitytask.exception;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    private String message;
    private String code;
}
