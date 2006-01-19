package fr.umlv.ir3.emagine.teachertutor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class TeacherCreateAction extends BaseAction {

	/**
	 * The administrator wants to show a new create form.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		TeacherTutorModifyForm teacherModifyForm = (TeacherTutorModifyForm) form;
		// Retrieve all departments and set them in the form
		teacherModifyForm.reset();
		//teacherModifyForm.setDepartments(Arrays.asList(DepartmentEnum.values()));
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	/**
	 * The administrator wants to create an user.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		TeacherTutorModifyForm teacherModifyForm = (TeacherTutorModifyForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		TeacherTutorManager teacherTutorManager = managerManager.getTeacherTutorManager();
		
		try {
			// Init teacher
			TeacherTutor tutor = new TeacherTutor();
			tutor.setEmail(teacherModifyForm.getMail());
			tutor.setFax(teacherModifyForm.getFax());
			tutor.setAddressProfessional(new Address());
			tutor.getAddressProfessional().setCity(teacherModifyForm.getCity());
			//tutor.getAddressProfessional().setCountry(CountryEnum.France);
			//tutor.getAddressProfessional().setDepartment(DepartmentEnum.valueOf(teacherModifyForm.getIdDepartment()));
			tutor.getAddressProfessional().setPostalCode(teacherModifyForm.getPostalCode());
			tutor.getAddressProfessional().setStreet(teacherModifyForm.getAddress());
			tutor.setFirstName(teacherModifyForm.getFirstName());
			tutor.setLastName(teacherModifyForm.getLastName());
			tutor.setMobilePhone(teacherModifyForm.getCellular());
			tutor.setPhone(teacherModifyForm.getPhone());

			// Create a teacher
			teacherTutorManager.create(tutor);

			errors.add("confirm", new ActionMessage("teacher.create.confirm")); // TODO A revoir
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
