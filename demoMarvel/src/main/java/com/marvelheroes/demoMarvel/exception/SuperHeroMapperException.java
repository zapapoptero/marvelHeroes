package com.marvelheroes.demoMarvel.exception;

/**
 * The Class SuperHeroException.
 *
 * @author eduardo
 */
public class SuperHeroMapperException  extends Exception{

	/**
	   * Instantiates a new resource no found exception.
	   *
	   * @param message the message
	   * @param cause the cause
	   */
	  public SuperHeroMapperException(String message, Throwable cause) {
	    super(message, cause);
	  }

	  /**
	   * Instantiates a new resource no found exception.
	   *
	   * @param message the message
	   */
	  public SuperHeroMapperException(String message) {
	    super(message);
	  }

	  /**
	   * Instantiates a new resource no found exception.
	   */
	  public SuperHeroMapperException() {
	    super();
	  }

	  /**
	   * Instantiates a new resource no found exception.
	   *
	   * @param cause the cause
	   */
	  public SuperHeroMapperException(Throwable cause) {
	    super(cause);
	  }
}