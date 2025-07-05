package com.neru.backend.domain.ai.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DiaryType {
    GRATITUDE("GRATITUDE"),
    EMOTION("EMOTION");

    private final String type;
}
