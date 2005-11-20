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

import fr.umlv.ir3.emagine.dao.DAOFactory;
import fr.umlv.ir3.emagine.dao.DAOFactoryChooser;
import fr.umlv.ir3.emagine.dao.UserDAO;
import fr.umlv.ir3.emagine.dao.DAOFactoryChooser.DataSourceType;

/**
 * @author Administrateur
 *
 */
public class UserCreateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserCreateForm userCreateForm  = (UserCreateForm) form;
		
		//FIXME : Déplacer le DAOChooser à l'initialisation de l'application
		DAOFactoryChooser.setCurrentDAOFactory(DataSourceType.HIBERNATE);
		DAOFactory daoFactory = DAOFactoryChooser.getCurrentDAOFactory();
		
		UserDAO userDAO = daoFactory.getUserDAO();
		
		
		User user = new User(userCreateForm.getFirstName() , userCreateForm.getLastName());
		
		daoFactory.beginTransaction() ;
		userDAO.create(user);
		daoFactory.commitTransaction();
		

		return  mapping.findForward("success");
	}

}
