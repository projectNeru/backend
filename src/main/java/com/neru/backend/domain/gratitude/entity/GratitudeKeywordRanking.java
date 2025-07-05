package com.neru.backend.domain.gratitude.entity;

import com.neru.backend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "gratitude_keyword_ranking")
public class GratitudeKeywordRanking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate weekStart;

    @Column(nullable = false, length = 100)
    private String keyword;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GratitudeKeywordType keywordType;

    @Column(nullable = false)
    private Integer rank;

    @Column(nullable = false)
    private Integer count;
}
