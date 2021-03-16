package com.marvelheroes.demoMarvel.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marvelheroes.demoMarvel.persistence.domain.SuperHero;

/**
 * The Interface SuperHerosRepository.
 */
@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {

/**
 * Find all by name contains.
 *
 * @param value the value
 * @return the list
 */
	//findByUsernameContaining COULD BE SAME WITH jpa sintax
@Query("SELECT sh FROM SuperHero sh WHERE LOWER(sh.nombreHeroe) LIKE CONCAT('%',:value,'%')"
		+ " OR  LOWER(sh.nombreHeroe) LIKE CONCAT('%',:value) OR LOWER(sh.nombreHeroe) LIKE CONCAT(:value,'%')")
List<SuperHero> findAllByNameContains(@Param("value") String value);
}
