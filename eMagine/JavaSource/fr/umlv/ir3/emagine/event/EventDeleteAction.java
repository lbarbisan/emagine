/**
 *
 */
package fr.umlv.ir3.emagine.event;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseManager;
import fr.umlv.ir3.emagine.util.base.EventableEntity;

public class EventDeleteAction extends BaseAction {

	/**
	 * The administrator wants to delete all several events.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();

		String parameter = request.getParameter("from");
		String [] ids = request.getParameterValues("currentSelectedIds");

		if(ids != null && ids.length > 0) {
			if(parameter != null && !"".equals(parameter)) {
				if("apprentice".equals(parameter)) {
					removeEvents(managerManager.getFirmActorManager(), request, ids, "apprenticeModifyForm", "idApprenticeToModify");
				}
				else if("firm".equals(parameter)) {
					removeEvents(managerManager.getFirmActorManager(), request, ids, "companyModifyForm", "idFirmToModify");
				}
				else if("teacher".equals(parameter)) {
					removeEvents(managerManager.getFirmActorManager(), request, ids, "teacherTutorModifyForm", "idTeacherTutorToModify");
				}
				else if("firmActor".equals(parameter)) {
					removeEvents(managerManager.getFirmActorManager(), request, ids, "firmActorModifyForm", "idFirmActorToModify");
				}
				else if("candidate".equals(parameter)) {
					removeEvents(managerManager.getCandidateManager(), request, ids, "candidateModifyForm", "idCandidateToModify");
				}
			}
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}	
	
	private <E extends EventableEntity, D extends BaseDAO<E>, M extends BaseManager<E, D>> void removeEvents(M manager, HttpServletRequest request, String[] ids, String formName, String property) throws NumberFormatException, EMagineException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		E entity = manager.retrieve(
				Long.parseLong(
						BeanUtils.getNestedProperty(
								request.getSession().getAttribute(formName), property)));
		for (String id : ids)
			entity.getEvents().remove(manager.retrieve(Long.parseLong(id)));
		manager.update(entity);
	}
}
