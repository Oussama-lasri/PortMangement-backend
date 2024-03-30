package com.example.portmanagement.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Table(name="CrewMembers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CrewMember {

    @Id
    private int id ;


    @Column(nullable = false)
    private String name ;


    @Column(nullable = false)
    private String location ;

    @Column(nullable = true)
    private String role ;

}
