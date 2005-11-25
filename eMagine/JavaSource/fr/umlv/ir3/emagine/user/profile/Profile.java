package fr.umlv.ir3.emagine.user.profile;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Profile extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3504019715473060113L;


	
	@Column(unique = true)
	private String name;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@OrderBy("name")
	private List<Right> rights;
	private String description;
	
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
