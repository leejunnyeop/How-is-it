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
        @UniqueConstraint(columnNames = {"users_id", "profileBoard_id"})
})
public class MentorLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private CustomUser usersId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileBoard_id", nullable = false)
    private ProfileBoard profileBoardId;
}
