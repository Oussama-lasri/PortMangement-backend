package com.example.portmanagement.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name="RepairRequests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RepairRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requestId;
    private Date dateRequested;

    @ManyToOne
    private Ship ship;

    private String description;
    private String status;
}
