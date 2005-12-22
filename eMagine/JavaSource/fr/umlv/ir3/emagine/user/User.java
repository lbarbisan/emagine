package fr.umlv.ir3.emagine.user;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.modification.EditableEntity;
import fr.umlv.ir3.emagine.modification.Modification;
import fr.umlv.ir3.emagine.user.profile.Profile;

@Entity(access = AccessType.FIELD)
@Table(name = "applicationuser")
public class User extends EditableEntity{

	private static final long serialVersionUID = 3947274315317297604L;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "profile_id")
	private Profile profile;
	@OneToMany(cascade = {CascadeType.ALL},
			mappedBy = "userDestination")
	private List<Modification> modificationsInWait;
	@OneToMany(cascade = {CascadeType.ALL},
			mappedBy = "userSource")
	private List<Modification> modificationsRequest;
	
	
	@Column(unique = true)
	private String login;	
	@Column(unique = true)
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	
	public User(){}

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return Returns the login.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login The login to set.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return Returns the modificationsInWait.
	 */
	public List<Modification> getModificationsInWait() {
		return modificationsInWait;
	}

	/**
	 * @param modificationsInWait The modificationsInWait to set.
	 */
	public void setModificationsInWait(List<Modification> modificationsInWait) {
		this.modificationsInWait = modificationsInWait;
	}

	/**
	 * @return Returns the modificationsRequest.
	 */
	public List<Modification> getModificationsRequest() {
		return modificationsRequest;
	}

	/**
	 * @param modificationsRequest The modificationsRequest to set.
	 */
	public void setModificationsRequest(List<Modification> modificationsRequest) {
		this.modificationsRequest = modificationsRequest;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the profile.
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile The profile to set.
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}	
}
