package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RecordEntity;

public interface RecordRepository extends JpaRepository<RecordEntity, UUID> {
    
}
