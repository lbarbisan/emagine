package fr.umlv.ir3.emagine.student.candidate.room;

import java.util.List;

import fr.umlv.ir3.emagine.student.candidate.Candidate;
import fr.umlv.ir3.emagine.student.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.util.BaseEntity;



public class Room extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2288855718464048519L;
	private String  name;
	private Integer capacity;
	private List<Candidate> candidates;
	private FormationCenter formationCenter;
	
}
