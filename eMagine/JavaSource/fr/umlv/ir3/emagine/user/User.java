package fr.umlv.ir3.emagine.user;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
@Table(name = "tbl_user")
public class User extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3947274315317297604L;
	@ManyToOne(cascade = {
			CascadeType.PERSIST, 
			CascadeType.MERGE, 
			CascadeType.REFRESH})
	Profile profile;
	
	String password;
	
	@Column(unique = true)
	String login;
	@Column(unique = true)
	String email;
	
	String firstName;
	String lastName;
	
	protected User(){}
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String property1) {
		this.password = property1;
	}

	@ManyToOne
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile property1) {
		this.profile = property1;
	}
	
	
}
