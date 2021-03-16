package com.marvelheroes.demoMarvel.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marvelheroes.demoMarvel.persistence.vo.SuperHeroVO;

/**
 * The Interface SuperHeroController.
 */
public interface SuperHeroController {

	/**
	 * Gets the super heros.
	 *
	 * @return the super heros
	 */
	@GetMapping(value = "/getSuperHeros", produces = MediaType.APPLICATION_JSON_VALUE)
	List<SuperHeroVO> getSuperHeros();

	/**
	 * Gets the super hero by id.
	 *
	 * @param id the id
	 * @return the super hero by id
	 */
	@GetMapping(value = "/getSuperHero/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	SuperHeroVO getSuperHeroById(@PathVariable(value = "id", required = true) Long id);

	/**
	 * Gets the super hero by name contains.
	 *
	 * @param value the value
	 * @return the super hero by name contains
	 */
	@GetMapping(value = "/getSuperHeroByNameContains/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<SuperHeroVO> getSuperHeroByNameContains(@PathVariable(value = "value", required = true) String value);

	/**
	 * Update hero.
	 *
	 * @param superHeroVO the super hero VO
	 */
	@PutMapping(value = "/updateHero")
	void updateHero(@RequestBody SuperHeroVO superHeroVO);

	/**
	 * Delete hero by id.
	 *
	 * @param id the id
	 */
	@DeleteMapping(value = "/deleteHero/{id}")
	void deleteHeroById(@PathVariable(value = "id", required = true) Long id);

	/**
	 * Delete hero.
	 *
	 * @param superHeroVO the super hero VO
	 */
	@DeleteMapping(value = "/deleteHero")
	void deleteHero(@RequestBody SuperHeroVO superHeroVO);
}
