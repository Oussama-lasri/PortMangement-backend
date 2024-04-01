package com.example.portmanagement.Models;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Catches")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Catches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String species;
    private int quantity;

    @ManyToOne
    private FishingTrip fishingTrip;
}
