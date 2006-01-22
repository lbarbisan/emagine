/**
 *
 */
package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class FormationCenterModifyAction extends BaseAction {

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
		FormationCenterModifyForm centerModifyForm = (FormationCenterModifyForm) form;
		
		try {
			// Retrieve the user we want to see (if he exists) 
			String idUser = request.getParameter("id");			
			if(idUser != null && !"".equals(idUser)) {
				FormationCenter center = managerManager.getFormationCenterManager().retrieve(Long.parseLong(idUser));
				centerModifyForm.setIdFormationCenterToModify(idUser);
				//centerModifyForm.setAddress(center.getAddress().getStreet());
				//centerModifyForm.setCity(center.getCity());
				//centerModifyForm.setIdDepartment(center.getAddress().getDepartment().getId().toString());
				centerModifyForm.setName(center.getName());
				//centerModifyForm.setPostalCode(center.getAddress().getPostalCode());
				centerModifyForm.setTelephone(center.getPhone());
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
		FormationCenterManager centerManager = managerManager.getFormationCenterManager();
		FormationCenterModifyForm centerModifyForm = (FormationCenterModifyForm) form;

		// Update the center
		try {
			FormationCenter center = centerManager.retrieve(Long.parseLong(centerModifyForm.getIdFormationCenterToModify()));
			center.setCity(centerModifyForm.getCity());
			Address address = new Address();
			address.setCity(centerModifyForm.getCity());
			address.setDepartment((DepartmentEnum)managerManager.getEmagineEnumManager().retrieve(Long.parseLong(centerModifyForm.getIdDepartment()),DepartmentEnum.class));
			address.setPostalCode(centerModifyForm.getPostalCode());
			address.setStreet(centerModifyForm.getAddress());
			center.setAddress(address);
			center.setName(centerModifyForm.getName());
			center.setPhone(centerModifyForm.getTelephone());
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
