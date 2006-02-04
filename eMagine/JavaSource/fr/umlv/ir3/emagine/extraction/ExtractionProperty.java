package fr.umlv.ir3.emagine.extraction;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.user.User;

/**
 * This class represents a property of an extraction type. It contains all the users that have chosen this property the last time they exported that extraction entity.
 * @author eMagine
 */
@Entity(access = AccessType.FIELD)
public class ExtractionProperty {

	@OneToMany(mappedBy = "user")
	@Cascade(CascadeType.ALL)
	@Column(unique = true)
	private List<User> users;
	
	private String name;

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the users. Can be an empty list.
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users The users to set. Can be an empty list.
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}


}
