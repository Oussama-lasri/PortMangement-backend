package com.example.portmanagement.Models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="FishingTrips")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FishingTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date date;
    private String location;
    @ManyToOne
    private CrewMember captain;

    @OneToMany(mappedBy = "fishingTrip")
    private List<CrewMember> memberList;
}
