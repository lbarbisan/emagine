package fr.umlv.ir3.emagine.extraction;

import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

@MustHaveRights("extraction")
// FIXME : rappeler l'utilité de cette classe ?!
public interface ExtractionManager extends BaseManager<Extraction, ExtractionDAO> {

	/**
	 * Saves the specified extraction config for the current user
	 * @param extractionForm
	 */
	public abstract void saveConfig(ExtractionConfig config) throws EMagineException;

	/**
	 * Retrieves the extraction config for the given extraction entity (in the config).
	 * If the given extraction entity doesn't exists in database, creates and saves it.
	 * If there is no config for the current user, creates and saves the given config for the user. 
	 * @param config
	 * @return the saved extraction config for the current user.
	 */
	public abstract ExtractionConfig retrieveCurrentUserConfig(ExtractionConfig config) throws EMagineException;

}