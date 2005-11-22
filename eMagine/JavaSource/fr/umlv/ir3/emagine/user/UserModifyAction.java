/**
 *  
 */
package fr.umlv.ir3.emagine.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import fr.umlv.ir3.emagine.util.DAOManager;


/**
 * @author Administrateur
 *
 */
public class UserModifyAction extends DispatchAction {

	
	public ActionForward userCreate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  
	{
		UserInformationForm userInformationForm  = (UserInformationForm) form;
		
		UserDAO userDAO = DAOManager.getUserDAO();
		
		User user = new User(userInformationForm.getFirstName() , userInformationForm.getLastName());
		
		DAOManager.beginTransaction() ;
		userDAO.create(user);
		DAOManager.commitTransaction();
		
		//Mise à jour dans la form de l'id
		userInformationForm.setId(user.getId());
		
		return  mapping.findForward("success"); //TODO PageDestination
	}
	
	public ActionForward userModify(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		UserInformationForm userInformationForm  = (UserInformationForm) form;
		
		UserDAO userDAO = DAOManager.getUserDAO();
		
		DAOManager.beginTransaction() ;
	
		User user =  userDAO.retrieve(userInformationForm.getId());
		
		user.setFirstName(userInformationForm.getFirstName());
		user.setLastName(userInformationForm.getLastName());
		
		userDAO.update(user);
		DAOManager.commitTransaction();	
		
		return  mapping.findForward("success"); //TODO PageDestination
	}

}
