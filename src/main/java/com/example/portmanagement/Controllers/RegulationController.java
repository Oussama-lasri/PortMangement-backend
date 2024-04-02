package com.example.portmanagement.Controllers;

import com.example.portmanagement.DTO.Requests.PortRequest;
import com.example.portmanagement.DTO.Requests.RegulationRequest;
import com.example.portmanagement.Models.Port;
import com.example.portmanagement.Models.Regulations;
import com.example.portmanagement.Services.Impl.PortServiceImpl;
import com.example.portmanagement.Services.Impl.RegulationServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ports")
@CrossOrigin
public class RegulationController {

    private final RegulationServiceImpl regulationService ;
    private final ModelMapper modelMapper ;

    public RegulationController(RegulationServiceImpl regulationService, ModelMapper modelMapper) {
        this.regulationService = regulationService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Regulations> create(@Valid @RequestBody RegulationRequest regulationRequest){
        Regulations regulation = regulationService.create(modelMapper.map(regulationRequest, Regulations.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(regulation);
    }

    @GetMapping
    public ResponseEntity<List<Regulations>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(regulationService.findAll());
    }

    @GetMapping("{regulation_id}")
    public ResponseEntity<Regulations> findById(@PathVariable Long regulation_id){
        return ResponseEntity.status(HttpStatus.OK).body(regulationService.findById(regulation_id));
    }

    @PutMapping("{regulation_id}")
    public ResponseEntity<Regulations> findById(@PathVariable Long regulation_id  , @Valid @RequestBody RegulationRequest regulationRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(regulationService.update(regulation_id ,modelMapper.map(regulationRequest, Regulations.class)) );
    }

    @DeleteMapping("{regulation_id}")
    public ResponseEntity<?> delete(@PathVariable Long regulation_id  ) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deleted");
    }
}
