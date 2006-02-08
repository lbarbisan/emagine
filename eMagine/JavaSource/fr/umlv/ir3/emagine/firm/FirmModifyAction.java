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
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
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

				// Retrieve the firm to modify
				Firm firm = managerManager.getFirmManager().retrieve(Long.parseLong(idFirm));

				// Reset all form
				firmModifyForm.reset();

				// Set infos
				firmModifyForm.setIdFirmToModify(idFirm);
				firmModifyForm.setName(firm.getName());
				firmModifyForm.setEmail(firm.getEmail());
				firmModifyForm.setFax(firm.getFax());
				firmModifyForm.setPhone(firm.getPhone());
				firmModifyForm.setWeb(firm.getWebSite());
				firmModifyForm.setChildFirms(firm.getChildfirm());
				firmModifyForm.setEvents(firm.getEvents());

				// Parent firm
				if(firm.getMotherFirm() != null) {
					firmModifyForm.setIdParentFirm(Long.toString(firm.getMotherFirm().getId()));
					firmModifyForm.setNameParentFirm(firm.getMotherFirm().getName());
				}
				
				/*** Set address component ***/
				if(firm.getAddress() != null) {

					// Number of street and street
					firmModifyForm.setAddress(firm.getAddress().getStreet());

					// Postal code
					firmModifyForm.setPostalCode(firm.getAddress().getPostalCode());

					// Department
					if(firm.getAddress().getDepartment() != null)
						firmModifyForm.setIdDepartment(Long.toString(firm.getAddress().getDepartment().getId()));

					// City
					firmModifyForm.setCity(firm.getAddress().getCity());

					// Country
					firmModifyForm.setCountry("");
				}
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
		FirmModifyForm firmModifyForm = (FirmModifyForm) form;

		// Update the firm
		try {
			Firm firm = firmManager.retrieve(Long.parseLong(firmModifyForm.getIdFirmToModify()));
			
			// Create an address
			Address address = null;
			if(	(firmModifyForm.getIdDepartment() != null && !"".equals(firmModifyForm.getIdDepartment()))
					|| (firmModifyForm.getCity() != null && !"".equals(firmModifyForm.getCity()))
					|| (firmModifyForm.getPostalCode() != null && !"".equals(firmModifyForm.getPostalCode()))
					|| (firmModifyForm.getAddress() != null && !"".equals(firmModifyForm.getAddress()))) {
				
				address = (firm.getAddress() == null ? new Address() : firm.getAddress());
				address.setCity(firmModifyForm.getCity());
				address.setPostalCode(firmModifyForm.getPostalCode());
				address.setStreet(firmModifyForm.getAddress());
				address.setDepartment(firmModifyForm.getIdDepartment() != null && !"".equals(firmModifyForm.getIdDepartment()) ? (DepartmentEnum) ManagerManager.getInstance().getEmagineEnumManager().retrieve(Long.parseLong(firmModifyForm.getIdDepartment()),DepartmentEnum.class) : null);
			}
			
			firm.setAddress(address);
			firm.setMotherFirm(firmModifyForm.getIdParentFirm() != null && !"".equals(firmModifyForm.getIdParentFirm()) ? firmManager.retrieve(Long.parseLong(firmModifyForm.getIdParentFirm())) : null);
			firm.setName(firmModifyForm.getName());
			firm.setEmail(firmModifyForm.getEmail());
			firm.setFax(firmModifyForm.getFax());
			firm.setPhone(firmModifyForm.getPhone());
			firm.setWebSite(firmModifyForm.getWeb());
						
			firmManager.update(firm);
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
