package fr.umlv.ir3.emagine.firm;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
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
	
	@OneToOne(mappedBy = "motherFirm")
	private Firm childfirm;
	@OneToOne
	@JoinColumn(name="motherfirm_id")
	private Firm motherFirm;
	@OneToMany(mappedBy = "firm")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Job> jobs;
	@OneToMany(mappedBy = "firm")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<FirmActor> firmActor;
	@OneToMany(mappedBy = "firm")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Apprentice> apprentices;	
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
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Firm getChildfirm() {
		return childfirm;
	}
	public void setChildfirm(Firm childFirm) {
		this.childfirm = childFirm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<FirmActor> getFirmActors() {
		return firmActor;
	}
	public void setFirmActor(List<FirmActor> firmActor) {
		this.firmActor = firmActor;
	}
	public String getFax() {
		return Fax;
	}
	public void setFax(String fax) {
		Fax = fax;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public Firm getMotherFirm() {
		return motherFirm;
	}
	public void setMotherfirm(Firm motherFirm) {
		this.motherFirm = motherFirm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Apprentice> getApprentices() {
		return apprentices;
	}
	public void setApprentices(List<Apprentice> apprentices) {
		this.apprentices = apprentices;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

}
