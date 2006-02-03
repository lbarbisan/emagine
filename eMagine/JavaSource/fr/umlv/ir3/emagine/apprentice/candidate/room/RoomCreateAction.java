package fr.umlv.ir3.emagine.apprentice.candidate.room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class RoomCreateAction extends BaseAction {

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
		RoomModifyForm roomModifyForm = (RoomModifyForm) form;
		
		roomModifyForm.reset();
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	/**
	 * The administrator wants to create a new Room.
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
		RoomModifyForm roomModifyForm = (RoomModifyForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		RoomManager roomManager = managerManager.getRoomManager();
		
		System.out.println(roomModifyForm.getIdCenter());
		try {
			String idCenter = request.getParameter("idCenter");
			System.out.println("le centre: " + idCenter);
			if(idCenter != null && !"".equals(idCenter)) {
				// Init room
				Room room = new Room();
				room.setCapacity(new Integer(roomModifyForm.getCapacity()));
				room.setFormationCenter(managerManager.getFormationCenterManager().retrieve(Long.parseLong(idCenter)));
				room.setName(roomModifyForm.getName());
				// Create a room
				roomManager.create(room);
				errors.add("confirm", new ActionMessage("room.create.confirm")); // TODO A revoir
			}
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
