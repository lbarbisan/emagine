package fr.umlv.ir3.emagine.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface MustHaveRights {
	/**
	 * The names of the rights which the current user must have to get access to the target method (attached to this annotation)
	 * @return
	 */
	String[] value();
}
