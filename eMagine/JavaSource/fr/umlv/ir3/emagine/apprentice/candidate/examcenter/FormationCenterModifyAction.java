/**
 *
 */
package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
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
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		try {
			// Retrieve the center we want to see (if he exists) 
			String idCenter = request.getParameter("id");
			
			if(idCenter == null || "".equals(idCenter))
				idCenter = centerModifyForm.getIdFormationCenterToModify();
			
			if(idCenter != null && !"".equals(idCenter)) {
				FormationCenter center = managerManager.getFormationCenterManager().retrieve(Long.parseLong(idCenter));
				centerModifyForm.setIdFormationCenterToModify(idCenter);
				centerModifyForm.setStreet(center.getAddress().getStreet());
				centerModifyForm.setCity(center.getAddress().getCity());
				centerModifyForm.setPostalCode(center.getAddress().getPostalCode());
				centerModifyForm.setName(center.getName());
				centerModifyForm.setPhone(center.getPhone());
				centerModifyForm.setRoom(center.getRooms());
				centerModifyForm.setDepartments((List<DepartmentEnum>)emagineEnumManager.findAll(DepartmentEnum.class));
				centerModifyForm.setIdDepartment(Long.toString(center.getAddress().getId()));
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
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();

		// Update the center
		try {
			FormationCenter center = centerManager.retrieve(Long.parseLong(centerModifyForm.getIdFormationCenterToModify()));
			Address address = new Address();
			address.setCity(centerModifyForm.getCity());
			address.setPostalCode(centerModifyForm.getPostalCode());
			address.setDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(centerModifyForm.getIdDepartment()), DepartmentEnum.class));
			address.setStreet(centerModifyForm.getStreet());
			center.setName(centerModifyForm.getName());
			center.setPhone(centerModifyForm.getPhone());
			
			center.getRooms().retainAll(centerModifyForm.getRoom());
			
			centerManager.update(center);
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
