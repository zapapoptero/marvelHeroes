/**
 * 
 */
package com.marvelheroes.demoMarvel.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperHeroException.
 *
 * @author eduardo
 */
public class SuperHeroException extends Exception {

	/**
	 * Instantiates a new resource no found exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public SuperHeroException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new resource no found exception.
	 *
	 * @param message the message
	 */
	public SuperHeroException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new resource no found exception.
	 */
	public SuperHeroException() {
		super();
	}

	/**
	 * Instantiates a new resource no found exception.
	 *
	 * @param cause the cause
	 */
	public SuperHeroException(Throwable cause) {
		super(cause);
	}
}