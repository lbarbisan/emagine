package fr.umlv.ir3.emagine.firm.actor;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.person.Person;
@Entity(access = AccessType.FIELD)
public class FirmActor extends Person {
	
	private static final long serialVersionUID = 6962218814666233077L;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "firm_id")
	private Firm firm;
	@Embedded
	private Address addressProfessional;
	private String Function;
	public Address getAddressProfessional() {
		return addressProfessional;
	}
	public void setAddressProfessional(Address addressProfessional) {
		this.addressProfessional = addressProfessional;
	}
	public Firm getFirm() {
		return firm;
	}
	public void setFirm(Firm firm) {
		this.firm = firm;
	}
	public String getFunction() {
		return Function;
	}
	public void setFunction(String function) {
		Function = function;
	}
}
