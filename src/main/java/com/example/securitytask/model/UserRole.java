package com.example.securitytask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRole implements GrantedAuthority {
    private String role;
    @Override
    public String getAuthority() {
        return role;
    }
}
