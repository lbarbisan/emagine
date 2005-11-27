package fr.umlv.ir3.emagine.teachertutor;

import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class TeacherTutorSearchForm extends SelectSearchForm<TeacherTutor> implements TeacherTutorSearchParam {
	
	private static final long serialVersionUID = -2405706291327109100L;

	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
