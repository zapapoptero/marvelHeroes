package com.marvelheroes.demoMarvel.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperHero.
 */
@Entity
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
    
    /**
     * Gets the id.
     *
     * @return the id
     */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the nombre heroe.
	 *
	 * @return the nombreHeroe
	 */
	public String getNombreHeroe() {
		return nombreHeroe;
	}

	/**
	 * Sets the nombre heroe.
	 *
	 * @param nombreHeroe the nombreHeroe to set
	 */
	public void setNombreHeroe(String nombreHeroe) {
		this.nombreHeroe = nombreHeroe;
	}

	/**
	 * Gets the nombre real.
	 *
	 * @return the nombreReal
	 */
	public String getNombreReal() {
		return nombreReal;
	}

	/**
	 * Sets the nombre real.
	 *
	 * @param nombreReal the nombreReal to set
	 */
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	/**
	 * Gets the fuerza.
	 *
	 * @return the fuerza
	 */
	public Double getFuerza() {
		return fuerza;
	}

	/**
	 * Sets the fuerza.
	 *
	 * @param fuerza the fuerza to set
	 */
	public void setFuerza(Double fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SuperHero [id=" + id + ", nombreHeroe=" + nombreHeroe + ", nombreReal=" + nombreReal + ", fuerza="
				+ fuerza + "]";
	}

}
