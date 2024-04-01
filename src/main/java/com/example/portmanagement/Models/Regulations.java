package com.example.portmanagement.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Entity
@Table(name="Regulations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Regulations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
}
