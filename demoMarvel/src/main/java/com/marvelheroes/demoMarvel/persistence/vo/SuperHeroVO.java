package com.marvelheroes.demoMarvel.persistence.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class SuperHeroVO.
 */
@Getter
@Setter
@ToString
public class SuperHeroVO {

    /** The id. */
    private Long id;
    
    /** The nombre heroe. */
    private String nombreHeroe;
    
    /** The nombre real. */
    private String nombreReal;
    
    /** The fuerza. */
    private Double fuerza;

   
}
