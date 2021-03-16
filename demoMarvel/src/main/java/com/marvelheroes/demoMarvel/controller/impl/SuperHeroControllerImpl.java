/**
 * 
 */
package com.marvelheroes.demoMarvel.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.marvelheroes.demoMarvel.controller.SuperHeroController;
import com.marvelheroes.demoMarvel.exception.SuperHeroErrorMessage;
import com.marvelheroes.demoMarvel.exception.SuperHeroException;
import com.marvelheroes.demoMarvel.exception.SuperHeroMapperException;
import com.marvelheroes.demoMarvel.mapper.SuperHeroMapper;
import com.marvelheroes.demoMarvel.persistence.vo.SuperHeroVO;
import com.marvelheroes.demoMarvel.service.SuperHeroService;


/**
 * The Class SuperHeroControllerImpl.
 *
 */
@RestController
@RequestMapping("/superHero")
public class SuperHeroControllerImpl implements SuperHeroController{

	
	private static final Logger LOG_ERROR = LoggerFactory.getLogger("error_logger");
	
	private static final Logger LOG = LoggerFactory.getLogger(SuperHeroControllerImpl.class);
	
	@Autowired
	private SuperHeroService superHeroService;
	
	@GetMapping(value = "/getSuperHeros",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperHeroVO> getSuperHeros(){
		LOG.info("We will call superHeroService.getSuperHeros");
		List<SuperHeroVO> listSuperHerosList  = new ArrayList();
		try {
			listSuperHerosList = superHeroService.getSuperHeros();
		} catch (SuperHeroMapperException e) {
			LOG_ERROR.error("Error mapping objetVO");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
		if(CollectionUtils.isEmpty(listSuperHerosList)) {
			LOG_ERROR.error("Error we dont have any super hero in database");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,SuperHeroErrorMessage.NONE_HERO_DATABASE);
		}
		return listSuperHerosList;
		
	}
	
	@GetMapping(value = "/getSuperHero/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public SuperHeroVO getSuperHeroById(@PathVariable(value = "id", required = true) Long id) {
		LOG.info("We will call superHeroService");
	}
}
