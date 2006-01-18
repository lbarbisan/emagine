package fr.umlv.ir3.emagine.user.profile;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Profile extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3504019715473060113L;
	
	@Column(unique = true)
	private String name;	
	@OneToMany 
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Right> rights = new ArrayList<Right>();
	@OneToMany(mappedBy = "profile")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<User> users;
	private String description;
	
	
	public Profile() {}
	
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
	public void addRights(Right right) {
		this.rights.add(right);
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
