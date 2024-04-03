package com.example.portmanagement.Controllers;

import com.example.portmanagement.DTO.Requests.CrewMemberRequest;
import com.example.portmanagement.Models.CrewMember;
import com.example.portmanagement.Services.Impl.CrewMemberServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crewMembers")
@CrossOrigin
public class CrewMemberController {
    private final CrewMemberServiceImpl crewMemberServiceImpl;
    private final ModelMapper modelMapper ;

    public CrewMemberController(CrewMemberServiceImpl crewMemberServiceImpl, ModelMapper modelMapper) {
        this.crewMemberServiceImpl = crewMemberServiceImpl;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CrewMember> create(@Valid @RequestBody CrewMemberRequest crewMemberRequest){
        CrewMember CrewMember = crewMemberServiceImpl.create(modelMapper.map(crewMemberRequest, CrewMember.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(CrewMember);
    }


    @GetMapping
    public ResponseEntity<List<CrewMember>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(crewMemberServiceImpl.findAll());
    }

    @GetMapping("{crewMember_id}")
    public ResponseEntity<CrewMember> findById(@PathVariable Long crewMember_id){
        return ResponseEntity.status(HttpStatus.OK).body(crewMemberServiceImpl.findById(crewMember_id));
    }

    @PutMapping("{crewMember_id}")
    public ResponseEntity<CrewMember> findById(@PathVariable Long crewMember_id  , @Valid @RequestBody CrewMemberRequest crewMemberRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(crewMemberServiceImpl.update(crewMember_id ,modelMapper.map(crewMemberRequest, CrewMember.class)) );
    }

    @DeleteMapping("{crewMember_id}")
    public ResponseEntity<?> delete(@PathVariable Long crewMember_id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deleted");
    }
}
