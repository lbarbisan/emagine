/**
 *  
 */
package fr.umlv.ir3.emagine.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.util.DAOManager;

/**
 * @author Administrateur
 *
 */
public class UserShowInformationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserInformationForm userShowInformationForm  = (UserInformationForm) form;
		
		User user = getUser(userShowInformationForm);
		userShowInformationForm.setFirstName(user.getFirstName());
		userShowInformationForm.setLastName(user.getLastName());
		
		return  mapping.findForward("success"); //TODO PageDestination
	}
	
	private User getUser(UserInformationForm userInformationForm)
	{
		UserDAO userDAO = DAOManager.getUserDAO();
		
		DAOManager.beginTransaction() ;
	
		User user =  userDAO.retrieve(userInformationForm.getId());
		
		DAOManager.commitTransaction();
		
		return user;
	}
}
