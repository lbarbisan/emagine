package fr.umlv.ir3.emagine.user;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.modification.Modification;
import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
@Table(name = "applicationuser")
public class User extends BaseEntity{

	private static final long serialVersionUID = 3947274315317297604L;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	Profile profile;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "userDestination")
	private List<Modification> modificationsInWait;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "userSource")
	private List<Modification> modificationsRequest;
	
	@Column(unique = true)
	String login;	
	@Column(unique = true)
	String email;
	String firstName;
	String lastName;
	String password;
	
	protected User(){}	
}
