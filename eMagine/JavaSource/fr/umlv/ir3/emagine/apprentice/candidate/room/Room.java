package fr.umlv.ir3.emagine.apprentice.candidate.room;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.modification.EditableEntity;


/**
 * 
 * @author Administrateur
 * @persistence Terminé - Vérifier Composite et primary
 */
@Entity(access = AccessType.FIELD)
public class Room extends EditableEntity {
	
	private static final long serialVersionUID = 2288855718464048519L;
	
	@OneToMany(	mappedBy = "room")
	private List<Candidate> candidates = new ArrayList<Candidate>();
	@ManyToOne()
	@JoinColumn(name="formationcenter_id")
	private FormationCenter formationCenter;
	
	private String  name;
	private Integer capacity;

	
	public Integer getNumberOfFreeSits() {
		return capacity - candidates.size();
	}
	
	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public FormationCenter getFormationCenter() {
		return formationCenter;
	}

	public void setFormationCenter(FormationCenter formationCenter) {
		this.formationCenter = formationCenter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
