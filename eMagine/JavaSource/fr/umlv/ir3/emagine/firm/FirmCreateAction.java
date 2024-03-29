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
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class FirmCreateAction extends BaseAction {

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
		FirmModifyForm firmModifyForm = (FirmModifyForm) form;
		
		// Retrieve all profiles and set them in the form
		try {
			firmModifyForm.reset();
			firmModifyForm.setDepartments((List <DepartmentEnum>)ManagerManager.getInstance().getEmagineEnumManager().findAll(DepartmentEnum.class));
			firmModifyForm.setParentFirms(ManagerManager.getInstance().getFirmManager().findAll());
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	
	/**
	 * The administrator wants to create a firm.
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
		FirmModifyForm firmModifyForm = (FirmModifyForm) form;
		FirmManager firmManager = ManagerManager.getInstance().getFirmManager();
		
		try {
			// Init firm
			Firm firm = new Firm();
			
			firm.setName(firmModifyForm.getName());
			firm.setFax(firmModifyForm.getFax());
			firm.setWebSite(firmModifyForm.getWeb());
			firm.setEmail(firmModifyForm.getEmail());
			firm.setEmail(firmModifyForm.getEmail());
			firm.setPhone(firmModifyForm.getPhone());
			
			// Create an address
			if(	(firmModifyForm.getIdDepartment() != null && !"".equals(firmModifyForm.getIdDepartment())) ||
					(firmModifyForm.getCity() != null && !"".equals(firmModifyForm.getCity())) ||
					(firmModifyForm.getPostalCode() != null && !"".equals(firmModifyForm.getPostalCode())) ||
					(firmModifyForm.getAddress() != null && !"".equals(firmModifyForm.getAddress()))) {
				Address address = new Address();

				if(	firmModifyForm.getCity() != null && !"".equals(firmModifyForm.getCity()))
					address.setCity(firmModifyForm.getCity());
				
				if(	firmModifyForm.getPostalCode() != null && !"".equals(firmModifyForm.getPostalCode()))
					address.setPostalCode(firmModifyForm.getPostalCode());
				
				if(	firmModifyForm.getAddress() != null && !"".equals(firmModifyForm.getAddress()))
					address.setStreet(firmModifyForm.getAddress());
				
				if(	firmModifyForm.getIdDepartment() != null && !"".equals(firmModifyForm.getIdDepartment()))
					address.setDepartment((DepartmentEnum) ManagerManager.getInstance().getEmagineEnumManager().retrieve(Long.parseLong(firmModifyForm.getIdDepartment()),DepartmentEnum.class));
				
				firm.setAddress(address);
			}

			// Set parent firm
			if(	firmModifyForm.getIdParentFirm() != null && !"".equals(firmModifyForm.getIdParentFirm()))
				firm.setMotherFirm(firmManager.retrieve(Long.parseLong(firmModifyForm.getIdParentFirm())));
			
			// Create a firm
			firmManager.create(firm);

			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("firm.create.confirm"));
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
