/**
 *  
 */
package fr.umlv.ir3.emagine.extraction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.util.base.Identifiable;

/**
 * Form that represents the final submited extraction form. It is attached to the action that generate the extracted file.
 * @author aogier
 */
public interface ExtractionForm<I extends Identifiable> extends ExtractionShowForm, ExtractionParams {
	/**
	 * @return <code>true</code> if the user wants to save the configuration, <code>false</code> otherwise.
	 */
	public boolean isSaveConfig();

	/**
	 * Sets <code>true</code> if the user wants to save the configuration, <code>false</code> otherwise.
	 * @param saveConfig
	 */
	public void setSaveConfig(boolean saveConfig);

	/**
	 * @return the name of the object that contains the list the user wants to extract. That name corresponds to the session attribute name of the object that contains the list.
	 */
	public String getExtractionObjectName();

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the extraction list corresponding to the extraction list name.
	 */
	public List<I> getExtractionList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response);
}
