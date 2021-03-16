package com.marvelheroes.demoMarvel.persistence.vo;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperHeroVO.
 */
public class SuperHeroVO {

    /** The id. */
    private Long id;
    
    /** The nombre heroe. */
    private String nombreHeroe;
    
    /** The nombre real. */
    private String nombreReal;
    
    /** The fuerza. */
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "SuperHeroVO [id=" + id + ", nombreHeroe=" + nombreHeroe + ", nombreReal=" + nombreReal + ", fuerza="
				+ fuerza + "]";
	}

	/**
	 * @return the fuerza
	 */
	public Double getFuerza() {
		return fuerza;
	}

	/**
	 * @param fuerza the fuerza to set
	 */
	public void setFuerza(Double fuerza) {
		this.fuerza = fuerza;
	}

   
}
