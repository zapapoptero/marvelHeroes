package com.marvelheroes.demoMarvel.controller.impl;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;	
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.marvelheroes.demoMarvel.exception.SuperHeroErrorMessage;
import com.marvelheroes.demoMarvel.exception.SuperHeroMapperException;
import com.marvelheroes.demoMarvel.persistence.vo.SuperHeroVO;
import com.marvelheroes.demoMarvel.service.SuperHeroService;

/**
 * The Class SuperHeroControllerImplTest.
 *
 * @author eduardo
 */
@RunWith(MockitoJUnitRunner.class)  
public class SuperHeroControllerImplTest {

	/** The super hero controller impl. */
	@InjectMocks
	private SuperHeroControllerImpl superHeroControllerImpl;
	
	/** The super hero service. */
	@Mock
	private SuperHeroService superHeroService;
	
	/** The valid super hero. */
	private SuperHeroVO validSuperHero;

	/**
	 * Inits the mocks.
	 */
	@Before
	public void initMocks() {
		validSuperHero.setId(1L);
		validSuperHero.setNombreHeroe("HULK");
		validSuperHero.setNombreReal("Bruce banner");
		validSuperHero.setFuerza(2.0);
			}
	
	/**
	 * Gets the super heros.
	 *
	 * @return the super heros
	 */
	@Test
	public void getSuperHeros() {	
		superHeroControllerImpl.deleteHeroById(Mockito.anyLong());
		//when method is void you verify with mockito
		Mockito.verify(superHeroService,times(1)).deleteById(Mockito.anyLong());
	}
	
	/**
	 * Test update correct.
	 *
	 * @throws SuperHeroMapperException the super hero mapper exception
	 */
	@Test
	public void testUpdateCorrect() throws SuperHeroMapperException {	
		List<SuperHeroVO> superHeroVO = new ArrayList();
		superHeroVO.add(validSuperHero);
		when(superHeroService.getSuperHeros()).thenReturn(superHeroVO);
		superHeroControllerImpl.getSuperHeros();
		assertEquals(superHeroControllerImpl.getSuperHeros(), superHeroVO);
	}
	
	/**
	 * Test update throw.
	 */
	@Test(expected = ResponseStatusException.class)
	public void testUpdateThrow() {	
		validSuperHero.setId(null);
		try {
		superHeroControllerImpl.updateHero(validSuperHero);
		}catch(ResponseStatusException e) {
			assertEquals(HttpStatus.BAD_REQUEST, e.getStatus());
			assertEquals(SuperHeroErrorMessage.ERROR_ID_NULL, e.getMessage());
			throw e;
		}
		
	}

}
