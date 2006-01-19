package fr.umlv.ir3.emagine.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface IsASearchParam {
	/**
	 * The names or paths of the database fields that match the given param
	 * @return
	 */
	String value();
	
	Class type()   default String.class;
}
