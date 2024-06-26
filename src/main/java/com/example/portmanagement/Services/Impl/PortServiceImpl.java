package com.example.portmanagement.Services.Impl;

import com.example.portmanagement.AbstactClasses.CrudServices;
import com.example.portmanagement.BaseInterfaces.IBaseCrudService;
import com.example.portmanagement.DTO.PortDTO;
import com.example.portmanagement.Models.CrewMember;
import com.example.portmanagement.Models.Port;
import com.example.portmanagement.Repositories.PortRepository;
import com.example.portmanagement.Services.IPortService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PortServiceImpl extends CrudServices<Port> implements IPortService {
    private final PortRepository portRepository;

    public PortServiceImpl(PortRepository portRepository) {
        this.portRepository = portRepository;
    }
    @Override
    protected JpaRepository<Port, Long> getRepository() {
        return this.portRepository;
    }

    @Override
    public Port update(long id, Port port) {
        Port portExist = this.portRepository.findById(id).orElseThrow(() -> new RuntimeException("CrewMember with id " + id + " not found"));


        portExist.setName(port.getName());
        portExist.setLocation(port.getLocation());


        return super.update(id, portExist);
    }
}
