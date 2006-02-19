package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.FirmManager;
import fr.umlv.ir3.emagine.firm.FirmModifyForm;
import fr.umlv.ir3.emagine.firm.Job;
import fr.umlv.ir3.emagine.firm.JobModifyForm;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class FirmActorCreateAction extends BaseAction {
	
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
		FirmActorModifyForm firmActorModifyForm = (FirmActorModifyForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		
		// Retrieve all profiles and set them in the form
		try {
			firmActorModifyForm.reset();
			firmActorModifyForm.setDepartments((List<DepartmentEnum>)managerManager.getEmagineEnumManager().findAll(DepartmentEnum.class));
			firmActorModifyForm.setFunctions((List<FunctionEnum>)managerManager.getEmagineEnumManager().findAll(FunctionEnum.class));
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
		ManagerManager managerManager = ManagerManager.getInstance();
		FirmManager firmManager = managerManager.getFirmManager();
		FirmActorModifyForm firmActorModifyForm = (FirmActorModifyForm) form;
		
		// Update the firmActor
		try {
			FirmActor actor = new FirmActor();
			Firm firm = firmManager.retrieve(Long.parseLong(((FirmModifyForm) request.getSession().getAttribute("companyModifyForm")).getIdFirmToModify()));
			
			// Create an address
			Address address = null;
			if(	(firmActorModifyForm.getIdDepartment() != null && !"".equals(firmActorModifyForm.getIdDepartment()))
					|| (firmActorModifyForm.getCity() != null && !"".equals(firmActorModifyForm.getCity()))
					|| (firmActorModifyForm.getAdress() != null && !"".equals(firmActorModifyForm.getAdress()))) {
				
				address = (actor.getAddressPersonnal() == null ? new Address() : actor.getAddressPersonnal());
				address.setCity(firmActorModifyForm.getCity());
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
			actor.setFirm(firm);
			
			if(firmActorModifyForm.getIdFunction() != null && !"".equals(firmActorModifyForm.getIdFunction()))
				actor.setFunction((FunctionEnum)managerManager.getEmagineEnumManager().find(firmActorModifyForm.getIdFunction(), FunctionEnum.class) );			
			
			firmManager.addFirmActor(firm, actor);
			
			errors.add("confirm", new ActionMessage("firmActor.create.confirm"));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}			
		
		// Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
