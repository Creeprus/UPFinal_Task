package com.example.RPD.Models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

public enum Role implements GrantedAuthority {
    USER,ADMIN,DETECTIVE,OFFICER;

    @Override
    public String getAuthority() {
        return name();
    }
}
