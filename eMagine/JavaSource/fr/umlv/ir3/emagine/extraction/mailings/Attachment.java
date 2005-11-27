package fr.umlv.ir3.emagine.extraction.mailings;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Attachment extends BaseEntity {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1158788337343652983L;
	
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
