/**
 *
 */
package fr.umlv.ir3.emagine.teachertutor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class TeacherModifyAction extends BaseAction {

	/**
	 * The administrator wants to show the details of teacher.
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
		ManagerManager managerManager = ManagerManager.getInstance();
		TeacherTutorModifyForm teacherModifyForm = (TeacherTutorModifyForm) form;
		
		try {
			// Retrieve the user we want to see (if he exists) 
			String idUser = request.getParameter("id");			
			if(idUser != null && !"".equals(idUser)) {
				TeacherTutor teacher = managerManager.getTeacherTutorManager().retrieve(Long.parseLong(idUser));
				teacherModifyForm.setIdTeacherTutorToModify(idUser);
				teacherModifyForm.setFirstName(teacher.getFirstName());
				teacherModifyForm.setLastName(teacher.getLastName());
				teacherModifyForm.setAddress(teacher.getAddressProfessional().getStreet());
				teacherModifyForm.setCellular(teacher.getMobilePhone());
				teacherModifyForm.setCity(teacher.getAddressProfessional().getCity());
				teacherModifyForm.setFax(teacher.getFax());
				//teacherModifyForm.setIdDepartment((DepartmentEnum.valueOf(teacher.getAddressProfessional().getDepartment().getName())).toString());
				teacherModifyForm.setMail(teacher.getEmail());
				teacherModifyForm.setPhone(teacher.getPhone());
				teacherModifyForm.setPostalCode(teacher.getAddressProfessional().getPostalCode());
				// FIXME remplire la liste des pupilles
				//teacherModifyForm.setPupils();
			}
			
		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}

	/**
	 * The administrator wants to modify the informations of user.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */	
	public ActionForward modify(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();
		TeacherTutorManager teacherManager = managerManager.getTeacherTutorManager();
		TeacherTutorModifyForm teacherModifyForm = (TeacherTutorModifyForm) form;

		// Update the Teacher
		try {
			TeacherTutor tutor = teacherManager.retrieve(Long.parseLong(teacherModifyForm.getIdTeacherTutorToModify()));
			tutor.getAddressProfessional().setCity(teacherModifyForm.getCity());
			tutor.getAddressProfessional().setCountry(CountryEnum.France);
			tutor.getAddressProfessional().setDepartment(DepartmentEnum.valueOf(teacherModifyForm.getIdDepartment()));
			tutor.getAddressProfessional().setPostalCode(teacherModifyForm.getPostalCode());
			tutor.getAddressProfessional().setStreet(teacherModifyForm.getAddress());
			tutor.setEmail(teacherModifyForm.getMail());
			tutor.setFax(teacherModifyForm.getFax());
			tutor.setFirstName(teacherModifyForm.getFirstName());
			tutor.setLastName(teacherModifyForm.getLastName());
			tutor.setMobilePhone(teacherModifyForm.getCellular());
			tutor.setPhone(teacherModifyForm.getPhone());
			teacherManager.update(tutor);
			
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
