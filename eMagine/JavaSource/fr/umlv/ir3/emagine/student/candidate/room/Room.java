package fr.umlv.ir3.emagine.student.candidate.room;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.student.candidate.Candidate;
import fr.umlv.ir3.emagine.student.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.util.BaseEntity;


/**
 * 
 * @author Administrateur
 * @persistence Terminé - Vérifier Composite et primary
 */
@Entity(access = AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED)
public class Room extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2288855718464048519L;
	private String  name;
	private Integer capacity;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "room")
	private List<Candidate> candidates;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="formationCenter_id")
	private FormationCenter formationCenter;
	
}
