package fr.umlv.ir3.emagine.extraction.mailings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.extraction.PropertiesExtractAction;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;

public class MailingListCreateAction extends PropertiesExtractAction {

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
		MailingListCreationForm mailingListModifyForm = (MailingListCreationForm) form;
		
		// Erase the title and comment in case the form was in session (must not be in the session)
		mailingListModifyForm.setTitle("");
		mailingListModifyForm.setComment("");

		// Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	
	/**
	 * The administrator wants to create a mailing type.
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
		MailingListCreationForm mailingListModifyForm = (MailingListCreationForm) form;
		MailingListManager mailingListManager = ManagerManager.getInstance().getMailingListManager();
		
		try {
			// Get the params entered by the user
			
			MailingList mailingList = new MailingList();
			
			mailingList.setComment(mailingListModifyForm.getComment());
			mailingList.setTitle(mailingListModifyForm.getTitle());
			mailingList.setPersons(mailingListModifyForm.getExtractionList(mapping, form, request, response));

			// Create a mailing type
			mailingListManager.create(mailingList);

			errors.add("confirm", new ActionMessage("mailingList.create.confirm"));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
