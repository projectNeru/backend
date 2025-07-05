package com.neru.backend.domain.analysis.model;

import com.neru.backend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "emotion_analysis")
public class EmotionAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate weekStart;

    @Column(columnDefinition = "TEXT")
    private String radar;

    @Column(columnDefinition = "JSON")
    private String topDetail;

    @Column(columnDefinition = "JSON")
    private String topKeywords;

    @Column(columnDefinition = "JSON")
    private String wordcloud;
}
