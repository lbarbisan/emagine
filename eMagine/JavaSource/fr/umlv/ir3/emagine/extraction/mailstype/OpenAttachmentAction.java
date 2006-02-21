package fr.umlv.ir3.emagine.extraction.mailstype;

import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class OpenAttachmentAction extends BaseAction {

	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseAction#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		if(!"".equals(id)) {
			
			MailingType mailingType = ManagerManager.getInstance().getMailingTypeManager().retrieve(Long.parseLong(id));
			OutputStream os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int i = 0;
			
			response.setContentType(mailingType.getContentType());
			response.setContentLength(mailingType.getFileSize());
	
			FileInputStream in = new FileInputStream(UploadUtil.getFileUploaded(mailingType.getFilePath()));
			while ((i = in.read(buffer)) > 0)
				os.write(buffer, 0, i);
	
			os.flush();
			os.close();
		}
		
		return null;
	}
}
