package com.marvelheroes.demoMarvel.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.marvelheroes.demoMarvel.controller.impl.SuperHeroControllerImpl;
import com.marvelheroes.demoMarvel.exception.SuperHeroErrorMessage;
import com.marvelheroes.demoMarvel.exception.SuperHeroException;
import com.marvelheroes.demoMarvel.exception.SuperHeroMapperException;
import com.marvelheroes.demoMarvel.mapper.SuperHeroMapper;
import com.marvelheroes.demoMarvel.persistence.domain.SuperHero;
import com.marvelheroes.demoMarvel.persistence.repository.SuperHeroRepository;
import com.marvelheroes.demoMarvel.persistence.vo.SuperHeroVO;
import com.marvelheroes.demoMarvel.service.SuperHeroService;

/**
 * The Class SuperHeroServiceImpl.
 */
@Service("SuperHeroService")
public class SuperHeroServiceImpl implements SuperHeroService {

	/** The Constant LOG_ERROR. */
	private static final Logger LOG_ERROR = LoggerFactory.getLogger("error_logger");

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(SuperHeroControllerImpl.class);

	/** The super hero mapper. */
	@Autowired
	private SuperHeroMapper superHeroMapper;

	/** The super hero repository. */
	@Autowired
	private SuperHeroRepository superHeroRepository;

	/**
	 * Gets the super heros.
	 *
	 * @return the super heros
	 * @throws SuperHeroMapperException the super hero mapper exception
	 */
	@Override
	public List<SuperHeroVO> getSuperHeros() throws SuperHeroMapperException {
		return superHeroMapper.entityListToClass(superHeroRepository.findAll());

	}

	/**
	 * Gets the super hero by id.
	 *
	 * @param id the id
	 * @return the super hero by id
	 * @throws SuperHeroException the super hero exception
	 */
	@Override
	public SuperHeroVO getSuperHeroById(Long id) throws SuperHeroException {
		if (!superHeroRepository.findById(id).isPresent()) {
			throw new SuperHeroException(SuperHeroErrorMessage.NONE_HERO_DATABASE);
		}
		return superHeroMapper.entityToClass(superHeroRepository.findById(id).get());
	}

	/**
	 * Gets the super hero by name contains.
	 *
	 * @param value the value
	 * @return the super hero by name contains
	 * @throws SuperHeroMapperException the super hero mapper exception
	 */
	@Override
	public List<SuperHeroVO> getSuperHeroByNameContains(String value) throws SuperHeroMapperException {
		value = value.toLowerCase();
		return superHeroMapper.entityListToClass(superHeroRepository.findAllByNameContains(value));
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	@Override
	public void deleteById(Long id) {
		superHeroRepository.deleteById(id);
	}

	/**
	 * Update hero.
	 *
	 * @param superHeroVO the super hero VO
	 * @throws SuperHeroException the super hero exception
	 */
	@Override
	public void updateHero(SuperHeroVO superHeroVO) throws SuperHeroException {
		SuperHero superHero = superHeroMapper.classToEntity(superHeroVO);
		if (superHeroRepository.existsById(superHero.getId())) {
			LOG.info("super hero with id {} will be updated", superHero.getId());
			superHeroRepository.save(superHero);
		} else {
			LOG_ERROR.error("Error superhero doenst exist in database");
			throw new SuperHeroException(SuperHeroErrorMessage.ERROR_NONE_HERO_ID);
		}
	}

}
