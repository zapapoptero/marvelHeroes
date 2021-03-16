package com.marvelheroes.demoMarvel.mapper;

import org.mapstruct.Mapper;

import com.marvelheroes.demoMarvel.persistence.domain.SuperHero;
import com.marvelheroes.demoMarvel.persistence.vo.SuperHeroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SuperHeroMapper.
 */
@Mapper( componentModel = "spring")
public interface SuperHeroMapper extends IMapper<SuperHero,SuperHeroVO>{
	

}
