package fr.umlv.ir3.emagine.user;

import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.hibernate.BaseEntity;

@Entity
public class User extends BaseEntity{
	String firstName;
	String lastName;
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
