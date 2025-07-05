package com.neru.backend.domain.gratitude.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GratitudeKeywordType {
    ACTION("ACTION"),
    PERSON("PERSON");

    private final String type;
}
