package com.iotplatform.user_service.handler;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final Long userId;

    public UserNotFoundException(Long userId) {
        super("User with id " + userId + " not found");
        this.userId = userId;
    }
}
