package fr.umlv.ir3.emagine.entreprise;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.BaseEntity;
/**
* @persistence Terminé
*/
@Entity(access = AccessType.FIELD)
public class Entreprise extends BaseEntity{

	private static final long serialVersionUID = 7717597898466060238L;
	
	@OneToOne
	private Entreprise motherEntreprise;
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "entreprise")
	private List<Job> jobs;
	
	@Embedded
	private Address address;
	
	private String name;
	private String phone;
	private String Fax;
	private String email;
	private String webSite;

}
