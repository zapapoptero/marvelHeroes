package com.marvelheroes.demoMarvel.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.marvelheroes.demoMarvel.anotation.TimerMethods;
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
public class SuperHeroControllerImpl implements SuperHeroController {

	/** The Constant LOG_ERROR. */
	private static final Logger LOG_ERROR = LoggerFactory.getLogger("error_logger");

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(SuperHeroControllerImpl.class);
	/** The super hero service. */
	@Autowired
	private SuperHeroService superHeroService;

	/**
	 * Gets the super heros.
	 *
	 * @return the super heros
	 */
	@GetMapping
	@TimerMethods
	public List<SuperHeroVO> getSuperHeros() {
		LOG.info("We will call superHeroService.getSuperHeros");
		List<SuperHeroVO> listSuperHerosList = new ArrayList();
		try {
			listSuperHerosList = superHeroService.getSuperHeros();
		} catch (SuperHeroMapperException e) {
			LOG_ERROR.error("Error mapping objetVO");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		if (CollectionUtils.isEmpty(listSuperHerosList)) {
			LOG_ERROR.error("Error we dont have any super hero in database");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					SuperHeroErrorMessage.NONE_HERO_DATABASE);
		}
		return listSuperHerosList;

	}

	/**
	 * Gets the super hero by id.
	 *
	 * @param id the id
	 * @return the super hero by id
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@TimerMethods
	@Cacheable(cacheNames = "ids", condition = "#id > 1")
	public SuperHeroVO getSuperHeroById(@PathVariable(value = "id", required = true) Long id) {
		LOG.info("We will call superHeroService.getSuperHeroById");
		try {
			return superHeroService.getSuperHeroById(id);
		} catch (SuperHeroException e) {
			LOG_ERROR.error("Error we dont have any super hero with id {} ", id);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/**
	 * Gets the super hero by name contains.
	 *
	 * @param value the value
	 * @return the super hero by name contains
	 */
	@GetMapping(value = "/getSuperHeroByNameContains/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
	@TimerMethods
	@Cacheable(cacheNames = "values")
	public List<SuperHeroVO> getSuperHeroByNameContains(@RequestParam("value") String value) {
		LOG.info("We will call superHeroService.getSuperHeroByNameContains");
		List<SuperHeroVO> listSuperHerosList = new ArrayList();
		try {
			listSuperHerosList = superHeroService.getSuperHeroByNameContains(value);
		} catch (SuperHeroMapperException e) {
			LOG_ERROR.error("Error mapping objetVO");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		if (CollectionUtils.isEmpty(listSuperHerosList)) {
			LOG_ERROR.error("Error we dont have any super hero in database");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					SuperHeroErrorMessage.NONE_HERO_DATABASE);
		}

		return listSuperHerosList;
	}

	/**
	 * Update hero.
	 *
	 * @param superHeroVO the super hero VO
	 */
	@Override
	@PutMapping
	@TimerMethods
	@CacheEvict(cacheNames = { "ids", "values" }, allEntries = true)
	public void updateHero(@RequestBody SuperHeroVO superHeroVO) {
		if (null == superHeroVO || null == superHeroVO.getId()) {
			LOG_ERROR.error("Error we dont have any super hero in database");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, SuperHeroErrorMessage.ERROR_ID_NULL);
		}
		try {
			superHeroService.updateHero(superHeroVO);
		} catch (SuperHeroException e) {
			LOG_ERROR.error("Error updating hero with id {}",superHeroVO.getId());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}

	}

	/**
	 * Delete hero by id.
	 *
	 * @param id the id
	 */
	@Override
	@DeleteMapping(value = "/{id}")
	@TimerMethods
	@CacheEvict(cacheNames = "ids", allEntries = true)
	public void deleteHeroById(@PathVariable Long id) {
		LOG.info("We will call superHeroService.deleteById");
		superHeroService.deleteById(id);

	}
}
