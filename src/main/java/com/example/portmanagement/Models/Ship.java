package com.example.portmanagement.Models;

import com.example.portmanagement.Enums.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Ships")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Ship {
    /**
     * - id: int                   |
     * | - name: string                     |
     * | - type: string                     |
     * | - size: Size                       |
     * | - crewCapacity: int                |
     * | - port: Port
     */
    @Id
    private int id ;

    private String name ;

    private String type ;

    private Size size ;

    private int crewCapacity ;



    @ManyToOne
    @JoinColumn(name = "port_id")
    private Port port ;

}
