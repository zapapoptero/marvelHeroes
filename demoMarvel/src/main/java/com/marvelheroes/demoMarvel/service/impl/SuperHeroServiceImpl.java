package com.marvelheroes.demoMarvel.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.marvelheroes.demoMarvel.exception.SuperHeroErrorMessage;
import com.marvelheroes.demoMarvel.exception.SuperHeroMapperException;
import com.marvelheroes.demoMarvel.mapper.SuperHeroMapper;
import com.marvelheroes.demoMarvel.persistence.repository.SuperHeroRepository;
import com.marvelheroes.demoMarvel.persistence.vo.SuperHeroVO;
import com.marvelheroes.demoMarvel.service.SuperHeroService;

@Service("SuperHeroService")
public class SuperHeroServiceImpl implements SuperHeroService{

	@Autowired
	private SuperHeroMapper superHeroMapper;
	
	@Autowired
	private SuperHeroRepository superHeroRepository;
	@Override
	public List<SuperHeroVO> getSuperHeros() throws SuperHeroMapperException {
		return superHeroMapper.entityListToClass(superHeroRepository.findAll());
	
		}

	
	
}
