package fr.umlv.ir3.emagine.entreprise;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.umlv.ir3.emagine.entreprise.actor.EntrepriseActor;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.BaseEntity;
/**
* @persistence Terminé
*/
@Entity(access = AccessType.FIELD)
public class Entreprise extends BaseEntity{

	private static final long serialVersionUID = 7717597898466060238L;
	
	@OneToOne(mappedBy = "motherEntreprise")
	private Entreprise childEntreprise;
	@OneToOne
	@JoinColumn(name="motherentreprise_id")
	private Entreprise motherEntreprise;
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "entreprise")
	private List<Job> jobs;
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "entreprise")
	private List<EntrepriseActor> entrepriseActor;
	@Embedded
	private Address address;
	
	private String name;
	private String phone;
	private String Fax;
	private String email;
	private String webSite;

}
