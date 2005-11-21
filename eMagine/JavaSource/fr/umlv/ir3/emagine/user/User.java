package fr.umlv.ir3.emagine.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.util.core.BaseEntity;

@Entity
@Table(name = "UserTbl")
public class User extends BaseEntity{
	
				Profile profile;
			String password;
		String login;
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

	public void setEmail(String property1) {
		this.email = property1;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String property1) {
		this.login = property1;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String property1) {
		this.password = property1;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile property1) {
		this.profile = property1;
	}
	
	
}
