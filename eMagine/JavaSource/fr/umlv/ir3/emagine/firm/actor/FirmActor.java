package fr.umlv.ir3.emagine.firm.actor;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.person.Person;
@Entity(access = AccessType.FIELD)
public class FirmActor extends Person {
	
	private static final long serialVersionUID = 6962218814666233077L;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "firm_id")
	private Firm firm;
	@OneToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "addressPersonnal_id")
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
