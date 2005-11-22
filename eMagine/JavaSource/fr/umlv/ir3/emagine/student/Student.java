package fr.umlv.ir3.emagine.student;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
@Table(name = "tbl_student")
public class Student extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3998703814616710370L;

/*	@OneToMany(cascade = {
			CascadeType.PERSIST, 
			CascadeType.MERGE, 
			CascadeType.REFRESH})
	@OrderBy("date")
	List<Abscence> abscences;*/
	
/*	@OneToOne(cascade = {
			CascadeType.PERSIST, 
			CascadeType.MERGE, 
			CascadeType.REFRESH})
	@JoinColumn(name="teachertutor_fk")
	@Column(unique = true)*/
	private TeacherTutor teacherTutor;

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
	
/*	@OneToOne(cascade = {
			CascadeType.PERSIST, 
			CascadeType.MERGE, 
			CascadeType.REFRESH})
	@JoinColumn(name="engineertutor_fk")
	@Column(unique = true)
	private EngineerTutor engineerTutor;*/
}
