package com.marvelheroes.demoMarvel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marvelheroes.demoMarvel.exception.SuperHeroMapperException;
import com.marvelheroes.demoMarvel.persistence.vo.SuperHeroVO;

public interface SuperHeroService {

	List<SuperHeroVO> getSuperHeros()throws SuperHeroMapperException;
	
	SuperHeroVO getSuperHeroById(Long id);
	
}
