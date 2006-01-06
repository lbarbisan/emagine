package fr.umlv.ir3.emagine.extraction;

import java.util.List;

import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.base.BaseManager;

@MustHaveRights("extraction")
// FIXME : rappeler l'utilité de cette classe ?!
public interface ExtractionManager extends BaseManager<Extraction, ExtractionDAO> {

	/**
	 * Return Selected Columns for specified User and specified View
	 */
	//TODO : Use case « Configurer l'extraction d'une liste »
	public abstract List<String> getSelectedColumns(
			ExtractionParams extractionParams);

	public abstract void setColumns(Extraction extraction, List<String> columns);

}