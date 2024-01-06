package com.example.howIsIt.repository;

import com.example.howIsIt.domain.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {

    // UserRepository의 메서드들


    Optional<CustomUser> findByUid(String uid);
}
