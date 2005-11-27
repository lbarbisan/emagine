package fr.umlv.ir3.emagine.entreprise;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.BaseModifyForm;

public class EntrepriseModifyForm extends BaseModifyForm  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6326596143394397304L;
	
	//FIXME: Manque le "titre" par rapport au CDCF
	private Entreprise entity = new Entreprise();
	private String passwordRepeat;
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO EntrepriseModifyForm.validate()
		return super.validate(mapping, request);
	}
	
	public Long getId() {
		return entity.getId();
	}
	public Entreprise getEntity() {
		return entity;
	}
	public String getName() {
		return entity.getName();
	}
	public void setName(String name) {
		entity.setName(name);
	}
	public Address getAddress() {
		return entity.getAddress();
	}
	public void setAddress(Address address) {
		entity.setAddress(address);
	}
	public Entreprise getChildEntreprise() {
		return entity.getChildEntreprise();
	}
	public void setChildEntreprise(Entreprise childEntreprise) {
		entity.setChildEntreprise(childEntreprise);
	}
	public Entreprise getMotherEntreprise() {
		return entity.getMotherEntreprise();
	}
	public void setMotherEntreprise(Entreprise motherEntreprise) {
		entity.setMotherEntreprise(motherEntreprise);
	}
	public String getEmail() {
		return entity.getEmail();
	}
	public void setEmail(String email) {
		entity.setEmail(email);
	}
	public String getFax() {
		return entity.getFax();
	}
	public void setFax(String fax) {
		entity.setFax(fax);
	}
	entity.getPhone();
	public String getLastName() {
		return entity.getLastName();
	}
	public void setLastName(String lastName) {
		entity.setLastName(lastName);
	}
	entity.getStudents();
	public String getLastName() {
		return entity.getLastName();
	}
	public void setLastName(String lastName) {
		entity.setLastName(lastName);
	}
	entity.getWebSite();
	public String getLastName() {
		return entity.getLastName();
	}
	public void setLastName(String lastName) {
		entity.setLastName(lastName);
	}
	public List<EntrepriseActor> getEntrepriseActor() {
		return entity.getEntrepriseActor();
	}
	public List<Event> getEvents() {
		return entity.getEvents();
	}
	public List<Job> getJobs() {
		return entity.getJobs();
	}
}
