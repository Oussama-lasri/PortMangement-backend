package com.example.portmanagement.Repositories;


import com.example.portmanagement.Models.Regulations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegulationRepository extends JpaRepository<Regulations, Long> {
}
