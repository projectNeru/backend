package com.neru.backend.domain.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {

    ACTIVE("ACTIVE"),
    LEAVE("LEAVE");

    private final String userState;

}