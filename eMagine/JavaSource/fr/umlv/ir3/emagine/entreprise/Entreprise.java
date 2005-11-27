package fr.umlv.ir3.emagine.entreprise;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.umlv.ir3.emagine.entreprise.actor.EntrepriseActor;
import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
/**
* @persistence Terminé
*/
@Entity(access = AccessType.FIELD)
@Table(uniqueConstraints =@UniqueConstraint(columnNames={
		"name"}))
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
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			mappedBy = "entreprise")
	private List<Student> students;
	@Embedded
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
	public Entreprise getChildEntreprise() {
		return childEntreprise;
	}
	public void setChildEntreprise(Entreprise childEntreprise) {
		this.childEntreprise = childEntreprise;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<EntrepriseActor> getEntrepriseActor() {
		return entrepriseActor;
	}
	public void setEntrepriseActor(List<EntrepriseActor> entrepriseActor) {
		this.entrepriseActor = entrepriseActor;
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
	public Entreprise getMotherEntreprise() {
		return motherEntreprise;
	}
	public void setMotherEntreprise(Entreprise motherEntreprise) {
		this.motherEntreprise = motherEntreprise;
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

}
