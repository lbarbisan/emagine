package fr.umlv.ir3.emagine.entreprise.actor;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.entreprise.Entreprise;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.Person;
@Entity(access = AccessType.FIELD)
public class EntrepriseActor extends Person {
	
	private static final long serialVersionUID = 6962218814666233077L;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;
	@Embedded
	private Address addressProfessional;
	private String Function;
}
