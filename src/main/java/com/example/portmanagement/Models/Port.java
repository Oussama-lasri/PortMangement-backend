
package com.example.portmanagement.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="Ports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Port {
    /**
     *  - name: string                     |
     * | - location: string
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String name ;


    @Column(nullable = false)
    private String location ;
    @OneToMany
    private Set<Ship> ships ;

}
