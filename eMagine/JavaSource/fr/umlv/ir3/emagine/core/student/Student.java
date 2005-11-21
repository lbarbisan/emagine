package fr.umlv.ir3.emagine.core.student;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.core.BaseEntity;
import fr.umlv.ir3.emagine.core.student.abscence.Abscence;

@Entity(access = AccessType.FIELD)
@Table(name = "tbl_student")
public class Student extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3998703814616710370L;

	@OneToMany(cascade = CascadeType.ALL)
	@OrderBy("date")
	List<Abscence> abscences;
	
	//FIXME : Bedirectionnal
	@ManyToOne()
	@JoinColumn(name="teachertutor_fk")
	private TeacherTutor teacherTutor;
	
	//FIXME : BeDirectionnal
	@ManyToOne
	@JoinColumn(name="engineertutor_fk")
	private EngineerTutor engineerTutor;

	/**
	 * @return Returns the abscences.
	 */
	public List<Abscence> getAbscences() {
		return abscences;
	}

	/**
	 * @param abscences The abscences to set.
	 */
	public void setAbscences(List<Abscence> abscences) {
		this.abscences = abscences;
	}

	/**
	 * @return Returns the engineerTutor.
	 */
	public EngineerTutor getEngineerTutor() {
		return engineerTutor;
	}

	/**
	 * @param engineerTutor The engineerTutor to set.
	 */
	public void setEngineerTutor(EngineerTutor engineerTutor) {
		this.engineerTutor = engineerTutor;
	}

	/**
	 * @return Returns the teacherTutor.
	 */
	public TeacherTutor getTeacherTutor() {
		return teacherTutor;
	}

	/**
	 * @param teacherTutor The teacherTutor to set.
	 */
	public void setTeacherTutor(TeacherTutor teacherTutor) {
		this.teacherTutor = teacherTutor;
	}
}
