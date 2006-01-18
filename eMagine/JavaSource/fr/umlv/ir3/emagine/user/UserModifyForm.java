package fr.umlv.ir3.emagine.user;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.user.profile.Profile;


/**
 * Use to Use Create Form
 * @author jrenaudi
 *
 */
public class UserModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	/** User blinding **/
	private User user;
	
	/** User firstname **/
	private String firstName;

	/** User lastName **/
	private String lastName;
	
	/** User login **/
	private String login;
	
	/** User password **/
	private String password;
	
	/** User repassword **/
	private String repassword;
	
	/** Identifier of selected profile **/
	private String idProfile;
	
	/** User email **/
	private String email;
	
	/** List of all profils **/
	private Collection <Profile> profiles;

	/** Use to DispacthAction **/
	private String dispatch;


	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if(dispatch.equals("create")) {
			if(firstName.equals("") || lastName.equals("") || email.equals("") || login.equals(""))
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
			else if(!password.equals(repassword))
				errors.add("isNotTheSamePwd", new ActionMessage("user.create.error.isNotTheSamePwd"));
		}			

		return errors;
	}

	
	/**
	 * @return Returns the dispatch.
	 */
	public String getDispatch() {
		return dispatch;
	}

	/**
	 * @param dispatch The dispatch to set.
	 */
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

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
	 * @return Returns the idProfile.
	 */
	public String getIdProfile() {
		return idProfile;
	}

	/**
	 * @param idProfile The idProfile to set.
	 */
	public void setIdProfile(String idProfile) {
		this.idProfile = idProfile;
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
	 * @return Returns the profiles.
	 */
	public Collection<Profile> getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles The profiles to set.
	 */
	public void setProfiles(Collection<Profile> profiles) {
		this.profiles = profiles;
	}

	/**
	 * @return Returns the repassword.
	 */
	public String getRepassword() {
		return repassword;
	}

	/**
	 * @param repassword The repassword to set.
	 */
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	/**
	 * @return Returns the user.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
