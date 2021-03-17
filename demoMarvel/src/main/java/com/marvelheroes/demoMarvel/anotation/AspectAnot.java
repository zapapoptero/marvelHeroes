/**
 * 
 */
package com.marvelheroes.demoMarvel.anotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.marvelheroes.demoMarvel.controller.impl.SuperHeroControllerImpl;


/**
 * The Class AspectAnot.
 *
 */
@Aspect
@Component
public class AspectAnot {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(SuperHeroControllerImpl.class);
	
	/**
	 * Tiempo pasado.
	 *
	 * @param point the point
	 * @param timerMethods the timer methods
	 * @return the object
	 * @throws Throwable the throwable
	 */
	@Around("execution(* com.marvelheroes.demoMarvel.controller.*.*()) && @annotation(timerMethods)")
	public Object tiempoPasado(ProceedingJoinPoint point,TimerMethods timerMethods) throws Throwable {

		Long enterMethod = System.currentTimeMillis();
		Object obj = point.proceed();
		Long finishMethod = System.currentTimeMillis();
		Long totalTime = finishMethod - enterMethod;
		LOG.info(new StringBuilder("Method time : ").append(totalTime).append("s").toString());
		return obj;

	}
}