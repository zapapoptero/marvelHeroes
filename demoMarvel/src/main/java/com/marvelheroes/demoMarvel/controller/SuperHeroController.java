/**
 * 
 */
package com.marvelheroes.demoMarvel.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.marvelheroes.demoMarvel.persistence.vo.SuperHeroVO;

/**
 * The Interface SuperHeroController.
 */
@RestController
public interface SuperHeroController {

	@GetMapping(value = "/getSuperHeros" ,produces = MediaType.APPLICATION_JSON_VALUE)
	List<SuperHeroVO> getSuperHeros();
	
	@GetMapping(value = "/getSuperHero/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	SuperHeroVO getSuperHeroById(@PathVariable(value = "id", required = true) Long id);
}
