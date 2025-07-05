package com.neru.backend.domain.emotion.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmotionKeywordType {
    WORD("WORD"),
    SITUATION("SITUATION");

    private final String type;
}
