package fr.umlv.ir3.emagine.util.search;

public class ParameterInfo {
	
	private String name;
	private Class type;
	private String methodName;
	
	public ParameterInfo(String name,Class type, String methodName)
	{
		this.name = name;
		this.type = type;
		this.methodName  = methodName;
	}
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
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

}
