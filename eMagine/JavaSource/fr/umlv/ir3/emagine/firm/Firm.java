package fr.umlv.ir3.emagine.firm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.firm.actor.FirmActor;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.EventableEntity;
/**
* @persistence Terminé
*/
@Entity(access = AccessType.FIELD)
@Table(uniqueConstraints =@UniqueConstraint(columnNames={
		"name"}))
public class Firm extends EventableEntity {
	
	private static final long serialVersionUID = -4439188773689857587L;
	
	@OneToMany(mappedBy = "motherFirm")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Firm> childfirm = new ArrayList<Firm>();
	@ManyToOne
	@JoinColumn(name="motherfirm_id")
	private Firm motherFirm;
	@OneToMany(mappedBy = "firm")
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	private List<Job> jobs = new ArrayList<Job>();
	@OneToMany(mappedBy = "firm")
	@Cascade({CascadeType.ALL,  CascadeType.DELETE_ORPHAN})
	private List<FirmActor> firmActors = new ArrayList<FirmActor>();
	@OneToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "addresspersonnal_id")
	@Column(unique = true)
	private Address address;
	
	private String name;
	private String phone;
	private String Fax;
	private String email;
	private String webSite;
	/**
	 * @return Returns the address.
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address The address to set.
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return Returns the childfirm.
	 */
	public List<Firm> getChildfirm() {
		return childfirm;
	}
	/**
	 * @param childfirm The childfirm to set.
	 */
	public void setChildfirm(List<Firm> childfirm) {
		this.childfirm = childfirm;
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
	 * @return Returns the fax.
	 */
	public String getFax() {
		return Fax;
	}
	/**
	 * @param fax The fax to set.
	 */
	public void setFax(String fax) {
		Fax = fax;
	}
	/**
	 * @return Returns the firmActors.
	 */
	public List<FirmActor> getFirmActors() {
		return firmActors;
	}
	/**
	 * @param firmActors The firmActors to set.
	 */
	public void setFirmActors(List<FirmActor> firmActors) {
		this.firmActors = firmActors;
	}
	/**
	 * @return Returns the jobs.
	 */
	public List<Job> getJobs() {
		return jobs;
	}
	/**
	 * @param jobs The jobs to set.
	 */
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	/**
	 * @return Returns the motherFirm.
	 */
	public Firm getMotherFirm() {
		return motherFirm;
	}
	/**
	 * @param motherFirm The motherFirm to set.
	 */
	public void setMotherFirm(Firm motherFirm) {
		this.motherFirm = motherFirm;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone The phone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return Returns the webSite.
	 */
	public String getWebSite() {
		return webSite;
	}
	/**
	 * @param webSite The webSite to set.
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
}
