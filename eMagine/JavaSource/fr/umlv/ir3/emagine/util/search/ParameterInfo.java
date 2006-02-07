package fr.umlv.ir3.emagine.util.search;

import java.lang.reflect.Method;

public class ParameterInfo {
	
	private String name;
	private Class type;
	private Method method;
	
	public ParameterInfo(String name, Class type, Method method)
	{
		this.name = name;
		this.type = type;
		this.method = method;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class getType() {
		return type;
	}
	public void setType(Class type) {
		this.type = type;
	}

	/**
	 * @return Returns the method.
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * @param method The method to set.
	 */
	public void setMethod(Method method) {
		this.method = method;
	}

}
