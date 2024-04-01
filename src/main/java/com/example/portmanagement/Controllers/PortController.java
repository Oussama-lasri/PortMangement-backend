package com.example.portmanagement.Controllers;

import com.example.portmanagement.DTO.Requests.PortRequest;
import com.example.portmanagement.DTO.Responses.PortResponse;
import com.example.portmanagement.Models.Port;
import com.example.portmanagement.Repositories.PortRepository;
import com.example.portmanagement.Services.Impl.PortServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ports")
@CrossOrigin
public class PortController {

    private final PortServiceImpl portService ;
    private final ModelMapper modelMapper ;

    private final PortRepository portRepository;


    public PortController(PortServiceImpl portService, ModelMapper modelMapper, PortRepository portRepository) {
        this.portService = portService;
        this.modelMapper = modelMapper;
        this.portRepository = portRepository;
    }

    @PostMapping
    public ResponseEntity<Port> create(@Valid @RequestBody PortRequest portRequest){
        Port Port = portService.create(modelMapper.map(portRequest, Port.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(Port);
    }


    @GetMapping
    public ResponseEntity<List<Port>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(portService.findAll());
    }

    @GetMapping("{port_id}")
    public ResponseEntity<Port> findById(@PathVariable Long port_id){
        return ResponseEntity.status(HttpStatus.OK).body(portService.findById(port_id));
    }



}
