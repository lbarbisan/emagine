package fr.umlv.ir3.emagine.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.util.core.BaseEntity;

@Entity
@Table(name = "UserTbl")
public class User extends BaseEntity{
	
	String firstName;
	String lastName;
	
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
	
	
}
