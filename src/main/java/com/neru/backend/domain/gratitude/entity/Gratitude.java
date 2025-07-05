package com.neru.backend.domain.gratitude.entity;

import com.neru.backend.domain.user.entity.User;
import com.neru.backend.global.timestamp.AllTimestamp;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "gratitude")
public class Gratitude extends AllTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private java.time.LocalDate date;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String thankful1;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String thankful2;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String thankful3;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String good1;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String good2;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String good3;

    @Column(nullable = false)
    private Boolean aiReply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
