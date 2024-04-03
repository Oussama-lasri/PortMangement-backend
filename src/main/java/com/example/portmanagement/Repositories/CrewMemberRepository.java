package com.example.portmanagement.Repositories;

import com.example.portmanagement.Models.CrewMember;
import com.example.portmanagement.Models.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewMemberRepository extends JpaRepository<CrewMember, Long> {
}
