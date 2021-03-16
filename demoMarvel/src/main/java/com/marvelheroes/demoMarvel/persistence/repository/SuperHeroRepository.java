package com.marvelheroes.demoMarvel.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marvelheroes.demoMarvel.persistence.domain.SuperHero;

/**
 * The Interface SuperHerosRepository.
 */
@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {



}
