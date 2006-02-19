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
	@JoinColumn(name = "firm_id")
	private Firm firm;
	
	@OneToOne()	
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	@JoinColumn(name = "addressPersonnal_id")
	private Address addressProfessional;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="function_id")
	private FunctionEnum function;
	

	/**
	 * @return Returns the function.
	 */
	public FunctionEnum getFunction() {
		return function;
	}
	/**
	 * @param function The function to set.
	 */
	public void setFunction(FunctionEnum function) {
		this.function = function;
	}
	/**
	 * @return Returns the addressProfessional.
	 */
	public Address getAddressProfessional() {
		return addressProfessional;
	}
	/**
	 * @param addressProfessional The addressProfessional to set.
	 */
	public void setAddressProfessional(Address addressProfessional) {
		this.addressProfessional = addressProfessional;
	}
	/**
	 * @return Returns the firm.
	 */
	public Firm getFirm() {
		return firm;
	}
	/**
	 * @param firm The firm to set.
	 */
	public void setFirm(Firm firm) {
		this.firm = firm;
	}

}
