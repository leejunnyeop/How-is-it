package com.example.howIsIt.repository;

import com.example.howIsIt.domain.Mente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenteLoginRepository extends JpaRepository<Mente, Long> {
}
