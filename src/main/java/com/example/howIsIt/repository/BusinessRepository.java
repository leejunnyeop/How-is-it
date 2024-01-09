package com.example.howIsIt.repository;

import com.example.howIsIt.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {

    Business getBusinessByContent(String content);
}
