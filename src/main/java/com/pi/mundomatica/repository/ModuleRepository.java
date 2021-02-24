package com.pi.mundomatica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.mundomatica.model.ModuleEntity;

public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {

}
