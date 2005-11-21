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

import fr.umlv.ir3.emagine.dao.DAOFactory;
import fr.umlv.ir3.emagine.dao.DAOFactoryChooser;
import fr.umlv.ir3.emagine.dao.UserDAO;

/**
 * @author Administrateur
 *
 */
public class UserManageAction extends DispatchAction {

	
	public ActionForward userCreate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  
	{
		DAOFactory daoFactory = DAOFactoryChooser.getCurrentDAOFactory();
	
		UserInformationForm userInformationForm  = (UserInformationForm) form;
		
		UserDAO userDAO = daoFactory.getUserDAO();
		
		User user = new User(userInformationForm.getFirstName() , userInformationForm.getLastName());
		
		daoFactory.beginTransaction() ;
		userDAO.create(user);
		daoFactory.commitTransaction();
		
		return  mapping.findForward("success"); //TODO PageDestination
	}
	
	public ActionForward userModify(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		DAOFactory daoFactory = DAOFactoryChooser.getCurrentDAOFactory();
		
		UserInformationForm userInformationForm  = (UserInformationForm) form;
		
		UserDAO userDAO = daoFactory.getUserDAO();
		
		daoFactory.beginTransaction() ;
	
		User user =  userDAO.retrieve(userInformationForm.getId());
		
		user.setFirstName(userInformationForm.getFirstName());
		user.setLastName(userInformationForm.getLastName());
		
		userDAO.update(user);
		daoFactory.commitTransaction();	
		
		return  mapping.findForward("success"); //TODO PageDestination
	}

}
