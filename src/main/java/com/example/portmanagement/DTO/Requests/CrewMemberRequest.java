package com.example.portmanagement.DTO.Requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrewMemberRequest {
    @NotNull(message = "Nae cannot be null")
    @NotBlank(message = "Name must not be blank")
    private String name ;


    @NotNull(message = "Location cannot be null")
    @Size(min = 3, message = "Location must be at least 3 characters")
    @NotBlank(message = "Location must not be blank")
    private String location ;

    @NotNull(message = "role cannot be null")
    @NotBlank(message = "role must not be blank")
    private String role ;
}
