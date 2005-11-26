package fr.umlv.ir3.emagine.extraction.massmailing;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Model extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9009692835942232777L;
	
	private String name;
	private String path;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
