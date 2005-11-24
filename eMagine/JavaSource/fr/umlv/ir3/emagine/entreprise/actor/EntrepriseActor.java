package fr.umlv.ir3.emagine.entreprise.actor;

import javax.persistence.AccessType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.Person;
@Entity(access = AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED)
public class EntrepriseActor extends Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6962218814666233077L;
	private String Function;
	
	@Embedded
	private Address addressProfessional;
}
