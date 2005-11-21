package fr.umlv.ir3.emagine.core.student;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.core.BaseEntity;


@Entity(access = AccessType.FIELD)
@Table(name = "tbl_teachertutor")
public class TeacherTutor extends BaseEntity {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = -6468325376386661021L;
		@ManyToOne
		private Student student;

		/**
		 * @return Returns the student.
		 */
		public Student getStudent() {
			return student;
		}

		/**
		 * @param student The student to set.
		 */
		public void setStudent(Student student) {
			this.student = student;
		}
}
