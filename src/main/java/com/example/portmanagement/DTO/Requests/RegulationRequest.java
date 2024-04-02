package com.example.portmanagement.DTO.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegulationRequest {


    @NotNull(message = "title cannot be null")
    @Size(min = 3, message = "title must be at least 3 characters")
    @NotBlank(message = "title must not be blank")
    private String title;

    @NotNull(message = "description cannot be null")
    @NotBlank(message = "description must not be blank")
    private String description;

    @NotNull(message = "Start date cannot be null")
    private Date startDate;
    @NotNull(message = "Start date cannot be null")
    private Date endDate;
}
