package com.example.portmanagement.DTO.Requests;


import com.example.portmanagement.Models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

// register
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    private String name ;
    private String email ;
    private String password ;
    private Role role ;
}