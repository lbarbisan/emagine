package fr.umlv.ir3.emagine.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
	private long id;
	private String Name;
	
	protected Profile(){}
	
	@Override
	public boolean equals(Object obj) {
		return id == ((Profile)obj).getId();
	}
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
