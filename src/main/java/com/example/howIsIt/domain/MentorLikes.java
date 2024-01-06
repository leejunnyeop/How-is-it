package com.example.howIsIt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"users_id", "mentorProfile_id"})
})
public class MentorLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private CustomUser usersId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorProfile_id", nullable = false)
    private MentorProfile mentorProfileId;
}
