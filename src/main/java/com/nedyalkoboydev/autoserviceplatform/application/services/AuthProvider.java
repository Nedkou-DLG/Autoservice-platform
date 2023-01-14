package com.nedyalkoboydev.autoserviceplatform.application.services;

import com.nedyalkoboydev.autoserviceplatform.domain.entities.User;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AuthProvider<T extends User> {
    public T getCurrentUser(){
        return (T) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
