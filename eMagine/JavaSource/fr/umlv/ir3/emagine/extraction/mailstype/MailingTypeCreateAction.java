package fr.umlv.ir3.emagine.extraction.mailstype;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class MailingTypeCreateAction extends BaseAction {

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
		MailingTypeModifyForm mailingTypeModifyForm = (MailingTypeModifyForm) form;
		
		// Retrieve all profiles and set them in the form
		mailingTypeModifyForm.reset();

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
		MailingTypeModifyForm mailingTypeModifyForm = (MailingTypeModifyForm) form;
		MailingTypeManager mailingTypeManager = ManagerManager.getInstance().getMailingTypeManager();
		
		try {
			// Init firm
			MailingType mailingType = new MailingType();
			
			mailingType.setComment(mailingTypeModifyForm.getComment());
			mailingType.setTitle(mailingTypeModifyForm.getTitle());

			FormFile attachement = mailingTypeModifyForm.getAttachment(); 
			if(attachement != null && attachement.getFileSize() > 0) {
				File newFile = UploadUtil.saveFileUpload(attachement.getFileData(), attachement.getFileName());
				mailingType.setFilePath(newFile.getName());
				mailingType.setContentType(attachement.getContentType());
				mailingType.setFileSize(attachement.getFileSize());
				mailingType.setFileName(attachement.getFileName());
			}
			
			// Create a mailing type
			mailingTypeManager.create(mailingType);

			errors.add("confirm", new ActionMessage("mailingType.create.confirm"));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
