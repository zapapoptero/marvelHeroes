package com.marvelheroes.demoMarvel.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class SuperHero.
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "SUPERHERO")
public class SuperHero {

	
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** The nombre heroe. */
    @Column(name = "NOMBREHEROE", nullable = false)
    private String nombreHeroe;
    
    /** The nombre real. */
    @Column(name = "NOMBREREAL", nullable = false)
    private String nombreReal;
    
    /** The fuerza. */
    @Column(name = "FUERZA", nullable = false)
    private Double fuerza;
}
