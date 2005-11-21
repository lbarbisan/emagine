package fr.umlv.ir3.emagine.user;

import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.core.BaseEntity;

@Entity
public class Profile extends BaseEntity{
	
	String description;
	String name;
	
	protected Profile(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
