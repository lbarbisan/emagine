package fr.umlv.ir3.emagine.user;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.util.core.BaseEntity;


@Table(name = "tbl_profile")
@Entity(access = AccessType.FIELD)
public class Profile extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3504019715473060113L;

	private String description;
	
	@Column(unique = true)
	private String name;
	
	@OneToMany
	@OrderBy("name")
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
