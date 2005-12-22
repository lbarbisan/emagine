/**
 *
 */
package fr.umlv.ir3.emagine.modification;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.util.base.BaseAction;

public abstract class EditableAction<ManagerType extends EditableManager> extends BaseAction {

	public abstract ActionForward acceptFieldModification(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	
	public abstract ActionForward acceptAllModification(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;
}
