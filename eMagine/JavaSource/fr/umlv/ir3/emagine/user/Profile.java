package fr.umlv.ir3.emagine.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.util.core.BaseEntity;

@Entity
@Table(name = "tbl_profile")
public class Profile extends BaseEntity{
	
	String description;
	String name;
	List<Right> rights;
	
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

	/**
	 * @return Returns the rights.
	 */
	@OneToMany
	public List<Right> getRights() {
		return rights;
	}

	/**
	 * @param rights The rights to set.
	 */
	public void setRights(List<Right> rights) {
		this.rights = rights;
	}
	
	
}
