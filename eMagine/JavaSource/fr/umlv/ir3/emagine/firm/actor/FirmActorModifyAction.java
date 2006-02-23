/**
 *
 */
package fr.umlv.ir3.emagine.firm.actor;

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

public class FirmActorModifyAction extends BaseAction {

	/**
	 * The administrator wants to show the details of job.
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
		FirmActorManager firmActorManager = managerManager.getFirmActorManager();
		FirmActorModifyForm firmActorModifyForm = (FirmActorModifyForm) form;
		
		try {
			// Retrieve the firm we want to see (if he exists) 
			String id = request.getParameter("id");			
			if(id != null && !"".equals(id)) {

				// Retrieve the job to modify
				FirmActor actor = managerManager.getFirmActorManager().retrieve(Long.parseLong(id));

				// Reset all form
				firmActorModifyForm.reset();

				// Set infos
				firmActorModifyForm.setIdFirmActorToModify(actor.getId().toString());
				firmActorModifyForm.setLastname(actor.getLastName());
				firmActorModifyForm.setFirstname(actor.getFirstName());
				firmActorModifyForm.setFixPhone(actor.getPhone());
				firmActorModifyForm.setPortPhone(actor.getMobilePhone());
				firmActorModifyForm.setFax(actor.getFax());
				firmActorModifyForm.setMail(actor.getEmail());

				if(actor.getAddressPersonnal() != null) {
					Address address = actor.getAddressPersonnal();
					if(address.getStreet() != null)
						firmActorModifyForm.setAdress(address.getStreet());
					if(address.getCity() != null)
						firmActorModifyForm.setCity(address.getCity());
					if(address.getPostalCode() != null)
						firmActorModifyForm.setPostalCode(address.getPostalCode());
					if(address.getDepartment() != null)
						firmActorModifyForm.setIdDepartment(Long.toString(address.getDepartment().getId()));
				}
				
				if(actor.getFunction() != null)
					firmActorModifyForm.setIdFunction(Long.toString(actor.getFunction().getId()));

				if(firmActorManager.isEngineerTutor(actor))
					firmActorModifyForm.setResults((managerManager.getEngineerTutorManager().retrieve(actor.getId())).getApprentice());
			}

			firmActorModifyForm.setDepartments((List<DepartmentEnum>)managerManager.getEmagineEnumManager().findAll(DepartmentEnum.class));
			firmActorModifyForm.setFunctions((List<FunctionEnum>)managerManager.getEmagineEnumManager().findAll(FunctionEnum.class));
			
		} catch (EMagineException exception) {
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
		FirmActorManager firmActorManager = managerManager.getFirmActorManager();
		FirmActorModifyForm firmActorModifyForm = (FirmActorModifyForm) form;

		// Update the firmActor
		try {
			FirmActor actor = firmActorManager.retrieve(Long.parseLong(firmActorModifyForm.getIdFirmActorToModify()));
			
			// Set values
			// Create an address
			Address address = null;
			if(	(firmActorModifyForm.getIdDepartment() != null && !"".equals(firmActorModifyForm.getIdDepartment()))
					|| (firmActorModifyForm.getCity() != null && !"".equals(firmActorModifyForm.getCity()))
					|| (firmActorModifyForm.getAdress() != null && !"".equals(firmActorModifyForm.getAdress()))) {
				
				address = (actor.getAddressPersonnal() == null ? new Address() : actor.getAddressPersonnal());
				address.setCity(firmActorModifyForm.getCity());
				address.setPostalCode(firmActorModifyForm.getPostalCode());
				address.setStreet(firmActorModifyForm.getAdress());
				address.setDepartment(firmActorModifyForm.getIdDepartment() != null && !"".equals(firmActorModifyForm.getIdDepartment())
						? (DepartmentEnum) ManagerManager.getInstance().getEmagineEnumManager().retrieve(Long.parseLong(firmActorModifyForm.getIdDepartment()),DepartmentEnum.class) : null);
			}
			
			actor.setAddressPersonnal(address);
			actor.setLastName(firmActorModifyForm.getLastname());
			actor.setFirstName(firmActorModifyForm.getFirstname());
			actor.setPhone(firmActorModifyForm.getFixPhone());
			actor.setMobilePhone(firmActorModifyForm.getPortPhone());
			actor.setFax(firmActorModifyForm.getFax());
			actor.setEmail(firmActorModifyForm.getMail());
						
			if(firmActorModifyForm.getIdFunction() != null && !"".equals(firmActorModifyForm.getIdFunction()))
				actor.setFunction((FunctionEnum)managerManager.getEmagineEnumManager().find(firmActorModifyForm.getIdFunction(), FunctionEnum.class) );			

			firmActorManager.update(actor);
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
