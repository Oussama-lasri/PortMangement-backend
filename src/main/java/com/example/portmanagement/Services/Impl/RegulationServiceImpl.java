package com.example.portmanagement.Services.Impl;

import com.example.portmanagement.AbstactClasses.CrudServices;
import com.example.portmanagement.Models.CrewMember;
import com.example.portmanagement.Models.Port;
import com.example.portmanagement.Models.Regulations;
import com.example.portmanagement.Repositories.RegulationRepository;
import com.example.portmanagement.Services.IPortService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class RegulationServiceImpl extends CrudServices<Regulations> implements IPortService {

    private final RegulationRepository regulationRepository ;

    public RegulationServiceImpl(RegulationRepository regulationRepository) {
        this.regulationRepository = regulationRepository;
    }

    @Override
    protected JpaRepository<Regulations, Long> getRepository() {
        return this.regulationRepository;
    }

    @Override
    public Regulations update(long id, Regulations regulation) {
        Regulations regulationExist = this.regulationRepository.findById(id).orElseThrow(() -> new RuntimeException("Regulation with id " + id + " not found"));
        regulationExist.setTitle(regulation.getTitle());
        regulationExist.setDescription(regulation.getDescription());
        regulationExist.setStartDate(regulation.getStartDate());
        regulationExist.setEndDate(regulation.getEndDate());
        return super.update(id, regulationExist);
    }
}
