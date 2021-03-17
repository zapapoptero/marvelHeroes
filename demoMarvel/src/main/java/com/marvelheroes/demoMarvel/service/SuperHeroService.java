package com.marvelheroes.demoMarvel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marvelheroes.demoMarvel.exception.SuperHeroException;
import com.marvelheroes.demoMarvel.exception.SuperHeroMapperException;
import com.marvelheroes.demoMarvel.persistence.vo.SuperHeroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SuperHeroService.
 */
public interface SuperHeroService {

	/**
	 * Gets the super heros.
	 *
	 * @return the super heros
	 * @throws SuperHeroMapperException the super hero mapper exception
	 */
	List<SuperHeroVO> getSuperHeros() throws SuperHeroMapperException;

	/**
	 * Gets the super hero by id.
	 *
	 * @param id the id
	 * @return the super hero by id
	 * @throws SuperHeroException the super hero exception
	 */
	SuperHeroVO getSuperHeroById(Long id) throws SuperHeroException;

	/**
	 * Gets the super hero by name contains.
	 *
	 * @param value the value
	 * @return the super hero by name contains
	 * @throws SuperHeroMapperException the super hero mapper exception
	 */
	List<SuperHeroVO> getSuperHeroByNameContains(String value) throws SuperHeroMapperException;

	/**
	 * Update hero.
	 *
	 * @param superHeroVO the super hero VO
	 */
	void updateHero(SuperHeroVO superHeroVO) throws SuperHeroException;

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	void deleteById(Long id);
}
