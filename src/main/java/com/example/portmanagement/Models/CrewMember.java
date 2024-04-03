package com.example.portmanagement.Models;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="CrewMembers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrewMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @Column(nullable = false)
    private String name ;


    @Column(nullable = false)
    private String location ;

    @Column(nullable = true)
    private String role ;

    @ManyToOne
    private FishingTrip fishingTrip;

}
