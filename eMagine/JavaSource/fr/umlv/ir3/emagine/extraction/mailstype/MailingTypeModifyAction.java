/**
 *
 */
package fr.umlv.ir3.emagine.extraction.mailstype;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class MailingTypeModifyAction extends BaseAction {

	/**
	 * The administrator wants to show the details of mailing type.
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
		MailingTypeManager mailingTypeManager = ManagerManager.getInstance().getMailingTypeManager();
		MailingTypeModifyForm mailingTypeModifyForm = (MailingTypeModifyForm) form;
		
		try {
			// Retrieve the firm we want to see (if he exists) 
			String idMailingType = request.getParameter("id");			
			if(idMailingType != null && !"".equals(idMailingType)) {

				// Retrieve the firm to modify
				MailingType mailingType = mailingTypeManager.retrieve(Long.parseLong(idMailingType));

				// Reset all form
				mailingTypeModifyForm.reset();

				// Set infos
				mailingTypeModifyForm.setIdMailingTypeToModify(idMailingType);
				//mailingTypeModifyForm.setAttachment();
				mailingTypeModifyForm.setComment(mailingType.getComment());
				mailingTypeModifyForm.setTitle(mailingType.getTitle());
				
				// Create a mailing type
				mailingTypeManager.create(mailingType);

			}
			
			// Retrieve all sections and set them in the form
			// TODO mailingTypeModifyForm.setSections();

		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}

	/**
	 * The administrator wants to modify the informations of mailing type.
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
		MailingTypeManager mailingTypeManager = ManagerManager.getInstance().getMailingTypeManager();
		MailingTypeModifyForm mailingTypeModifyForm = (MailingTypeModifyForm) form;

		// Update the firm
		try {
			MailingType mailingType = mailingTypeManager.retrieve(Long.parseLong(mailingTypeModifyForm.getIdMailingTypeToModify()));
			
			//mailingType.setAttachments();
			mailingType.setComment(mailingTypeModifyForm.getComment());
			//mailingType.setMailCore();
			//mailingType.setMailObject();
			mailingType.setTitle(mailingTypeModifyForm.getTitle());
						
			mailingTypeManager.update(mailingType);
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
