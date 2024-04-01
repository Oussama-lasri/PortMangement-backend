package com.example.portmanagement.DTO.Responses;

import com.example.portmanagement.Models.Ship;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PortResponse {

    private Long id ;


    private String name ;


    private String location ;

    private Set<Ship> ships ;
}
