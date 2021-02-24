package com.pi.mundomatica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.mundomatica.model.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

}
