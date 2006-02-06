/**
 *
 */
package fr.umlv.ir3.emagine.firm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.user.profile.ProfileManager;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class FirmModifyAction extends BaseAction {

	/**
	 * The administrator wants to show the details of firm.
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
		FirmModifyForm firmModifyForm = (FirmModifyForm) form;
		
		try {
			// Retrieve the firm we want to see (if he exists) 
			String idFirm = request.getParameter("id");			
			if(idFirm != null && !"".equals(idFirm)) {
				Firm firm = managerManager.getFirmManager().retrieve(Long.parseLong(idFirm));

				firmModifyForm.setIdFirmToModify(idFirm);
				firmModifyForm.setName(firm.getName());

				if(firmModifyForm.getAddress() != null) {
					firmModifyForm.setPostalCode(firm.getAddress().getPostalCode());
					firmModifyForm.setAddress(firm.getAddress().getStreet());
					firmModifyForm.setCity(firm.getAddress().getCity());
					if(firm.getAddress().getDepartment() != null)
						firmModifyForm.setIdDepartment(Long.toString(firm.getAddress().getDepartment().getId()));
				}

				//firmModifyForm.setFixe(firm.getFixe());
			}
			
			// Retrieve all departments and set them in the form
			firmModifyForm.setDepartments((List <DepartmentEnum>)managerManager.getEmagineEnumManager().findAll(DepartmentEnum.class));

		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}

	/**
	 * The administrator wants to modify the informations of firm.
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
		FirmManager firmManager = managerManager.getFirmManager();
		ProfileManager profileManager = managerManager.getProfileManager();
		FirmModifyForm firmModifyForm = (FirmModifyForm) form;

		// Update the User
		try {
			Firm firm = firmManager.retrieve(Long.parseLong(firmModifyForm.getIdFirmToModify()));
			// Create an address
			if(	firmModifyForm.getIdDepartment() != null || !"".equals(firmModifyForm.getIdDepartment()) ||
					firmModifyForm.getCity() != null || !"".equals(firmModifyForm.getCity()) ||
					firmModifyForm.getPostalCode() != null || !"".equals(firmModifyForm.getPostalCode()) ||
					firmModifyForm.getAddress() != null || !"".equals(firmModifyForm.getAddress())) {
				Address address = (firm.getAddress() == null ? new Address() : firm.getAddress());
				address.setCity(firmModifyForm.getCity());
				address.setPostalCode(firmModifyForm.getPostalCode());
				address.setStreet(firmModifyForm.getAddress());
				address.setDepartment((DepartmentEnum) ManagerManager.getInstance().getEmagineEnumManager().retrieve(Long.parseLong(firmModifyForm.getIdDepartment()),DepartmentEnum.class));
				firm.setAddress(address);
			}

			// Set parent firm
			if(	firmModifyForm.getIdParent() != null || !"".equals(firmModifyForm.getIdParent()))
				firm.setMotherfirm(firmManager.retrieve(Long.parseLong(firmModifyForm.getIdParent())));
			
			firm.setName(firmModifyForm.getName());
			//firm.setFax();
			//firm.setFirmActor();
			//firm.setHumanName();
			//firm.setJobs();
			//firm.setWebSite();
			//firm.setApprentices();
			//firm.setPhone(firmModifyForm.getF);
			//firm.setEmail();
			//firm.setChildfirm();
			//firm.setEvents();
						
			firmManager.update(firm);
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
