package com.example.portmanagement.Repositories;

import com.example.portmanagement.Models.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortRepository extends JpaRepository<Port, Long> {
}
