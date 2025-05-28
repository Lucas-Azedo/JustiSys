package com.example.JustiSys.repository;

import com.example.JustiSys.model.LegalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LegalCaseRepository extends JpaRepository<LegalCase, UUID> {
}
