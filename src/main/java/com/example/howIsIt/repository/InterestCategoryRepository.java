package com.example.howIsIt.repository;

import com.example.howIsIt.domain.InterestCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestCategoryRepository extends JpaRepository<InterestCategory, Long> {

    InterestCategory getInterestCategoryByContent(String content);
}
