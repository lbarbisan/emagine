package fr.umlv.ir3.emagine.firm;

import java.util.Collection;

import org.apache.struts.action.ActionForm;


/**
 * Use to Use Create Form
 * @author jrenaudi
 *
 */
public class FirmListForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	/** List of all firms **/
	private Collection <Firm> firms;


	/**
	 * Reset information
	 */
	public void reset() {
		firms = null;
	}


	/**
	 * @return Returns the firms.
	 */
	public Collection<Firm> getFirms() {
		return firms;
	}

	/**
	 * @param firms The firms to set.
	 */
	public void setFirms(Collection<Firm> firms) {
		this.firms = firms;
	}
}
