/**
 *
 */
package fr.umlv.ir3.emagine.extraction.mailings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class MailingListModifyAction extends BaseAction {

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
		MailingListManager mailingListManager = ManagerManager.getInstance().getMailingListManager();
		MailingListCreationForm mailingListModifyForm = (MailingListCreationForm) form;
		
		try {
			// Retrieve the firm we want to see (if he exists) 
			String idMailingList = request.getParameter("id");			
			if(idMailingList != null && !"".equals(idMailingList)) {

				// Retrieve the firm to modify
				MailingList mailingList = mailingListManager.retrieve(Long.parseLong(idMailingList));

				// Reset all form
				mailingListModifyForm.reset();

				// Set infos
				mailingListModifyForm.setIdMailingListToModify(idMailingList);
				mailingListModifyForm.setPersonns(mailingList.getPersons());
				mailingListModifyForm.setComment(mailingList.getComment());
				mailingListModifyForm.setTitle(mailingList.getTitle());
				
				// Create a mailing type
				mailingListManager.create(mailingList);
			}
			
			// Retrieve all sections and set them in the form
			// TODO mailingListModifyForm.setSections();

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
		MailingListManager mailingListManager = ManagerManager.getInstance().getMailingListManager();
		MailingListCreationForm mailingListModifyForm = (MailingListCreationForm) form;

		// Update the firm
		try {
			MailingList mailingList = mailingListManager.retrieve(Long.parseLong(mailingListModifyForm.getIdMailingListToModify()));
			
			mailingList.setPersons(mailingListModifyForm.getPersonns());
			mailingList.setComment(mailingListModifyForm.getComment());
			mailingList.setTitle(mailingListModifyForm.getTitle());
						
			mailingListManager.update(mailingList);
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
