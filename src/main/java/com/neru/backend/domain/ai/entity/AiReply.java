package com.neru.backend.domain.ai.entity;

import com.neru.backend.global.timestamp.AllTimestamp;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "ai_reply")
public class AiReply extends AllTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DiaryType diaryType;

    @Column(nullable = false)
    private Long diaryId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
}
