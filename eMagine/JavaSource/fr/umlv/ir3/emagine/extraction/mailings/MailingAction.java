package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.Collections;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.extraction.mailstype.MailingType;
import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.MailManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;
import fr.umlv.ir3.emagine.util.person.Person;
import fr.umlv.ir3.emagine.util.search.SearchForm;

public class MailingAction extends BaseAction {

	/**
	 * Displays the mailingType form
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();

		MailingSearchForm mailingSearchForm = (MailingSearchForm)form;

		try {
			// Retreive the list of all the mailing types
			mailingSearchForm.setMailingTypes(ManagerManager.getInstance().getMailingTypeManager().findAll());
			
			// Set the selected mailing type to null, to know if the jsp can display it or not (here, to force the user to select a mailing type)
			mailingSearchForm.setMailingTypeId(null);
			
		} catch (EMagineException e) {
			// save the error
			addEMagineExceptionError(errors, e);
		}

		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	/**
	 * Send the given name to all of the selected persons of the mailing
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward mailing(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();

		MailingSearchForm mailingSearchForm = (MailingSearchForm)form;
		
		try {
			// Retrieve the file of the selected MailType
			final MailingType mailingType = ManagerManager.getInstance().getMailingTypeManager().retrieve(Long.parseLong(mailingSearchForm.getMailingTypeId()));
			String attachedFile = Bundles.getConfigBundle().getString("upload.dirPath")+mailingType.getFilePath();
			// Construct the list of email
			LinkedList<String> emails = new LinkedList<String>();
			for(Person person : ((SearchForm<Person>)request.getSession().getAttribute(mailingSearchForm.getExtractionObjectName())).getResults()) {
				emails.add(person.getEmail());
			}
			// Send the mail
			MailManager.sendMultiMailsBCC(emails, mailingType.getTitle(), mailingType.getComment(), Collections.singletonList(attachedFile));
		} catch (EMagineException e) {
			// save the error
			addEMagineExceptionError(errors, e);
		}
		
		if (errors.isEmpty()) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("mailing.action.sentOK"));
		}
		
		return successIfNoErrors(mapping, request, errors);
	}
}
