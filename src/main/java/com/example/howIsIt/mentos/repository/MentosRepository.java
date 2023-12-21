package com.example.howIsIt.mentos.repository;

import com.example.howIsIt.mentos.domain.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentosRepository extends JpaRepository<Mentor, Long> {
}
