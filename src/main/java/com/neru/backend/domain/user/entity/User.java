package com.neru.backend.domain.user.entity;

import com.neru.backend.global.timestamp.AllTimestamp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"user\"") // Note: 큰따옴표로 감싸기
@Getter
@NoArgsConstructor
public class User extends AllTimestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long kakaoId;

    @Column(nullable = false)
    private String nickname;

    private String profileImage;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime deletedAt;

    @Column
    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

}
