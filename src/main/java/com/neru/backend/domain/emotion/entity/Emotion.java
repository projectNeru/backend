package com.neru.backend.domain.emotion.entity;

import com.neru.backend.domain.user.entity.User;
import com.neru.backend.global.timestamp.AllTimestamp;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "emotion")
public class Emotion extends AllTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Integer intensity;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String caseContent; // 'case' is a reserved keyword in SQL, renamed to caseContent

    @Column(nullable = false, columnDefinition = "TEXT")
    private String think;

    @Column(nullable = false)
    private Boolean aiReply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emotion_category", referencedColumnName = "name", nullable = false)
    private EmotionCategory emotionCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emotion_detail", referencedColumnName = "name", nullable = false)
    private EmotionDetail emotionDetail;
}
