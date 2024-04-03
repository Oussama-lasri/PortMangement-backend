package com.example.portmanagement.Services.Impl;

import com.example.portmanagement.AbstactClasses.CrudServices;
import com.example.portmanagement.Models.CrewMember;
import com.example.portmanagement.Repositories.CrewMemberRepository;
import com.example.portmanagement.Services.ICrewMemberService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CrewMemberServiceImpl extends CrudServices<CrewMember> implements ICrewMemberService {
    private final CrewMemberRepository crewMemberRepository ;

    public CrewMemberServiceImpl(CrewMemberRepository crewMemberRepository) {
        this.crewMemberRepository = crewMemberRepository;
    }

    @Override
    protected JpaRepository<CrewMember, Long> getRepository() {
        return this.crewMemberRepository;
    }

    @Override
    public CrewMember update(long id, CrewMember crewMember) {
        CrewMember crewMemberExist = this.crewMemberRepository.findById(id).orElseThrow(() -> new RuntimeException("CrewMember with id " + id + " not found"));

        crewMemberExist.setRole(crewMember.getRole());
        crewMemberExist.setName(crewMember.getName());
        crewMemberExist.setLocation(crewMember.getLocation());
        crewMemberExist.setFishingTrip(crewMember.getFishingTrip());


        return super.update(id, crewMemberExist);
    }
}
