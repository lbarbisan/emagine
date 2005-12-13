package fr.umlv.ir3.emagine.extraction;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class ExtractionManager extends BaseManagerImpl<Extraction, ExtractionDAO> {


	/**
	 * Return Selected Columns for specified User and specified View
	 */
	//TODO : Use case « Configurer l'extraction d'une liste »
	public List<String> getSelectedColumns(ExtractionParams extractionParams)  
	{
		// TODO fr.umlv.ir3.emagine.extraction.ExtractionManager.getSelectedColumns(extractionParams)
		throw new RuntimeException(new EMagineException(
				"exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.extraction.ExtractionManager.getSelectedColumns(extractionParams)"));
	}

	
	public void setColumns(Extraction extraction, List<String> columns)  
	{
		// TODO fr.umlv.ir3.emagine.extraction.ExtractionManager.setColumns(extraction, columns)
		throw new RuntimeException(new EMagineException(
				"exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.extraction.ExtractionManager.setColumns(extraction, columns)"));
//		DAOManager.beginTransaction();
//		try {
//			extraction.setColumns(columns);
//			getDAO().update(extraction);
//			DAOManager.commitTransaction();
//		} catch (EMagineException e) {
//			// TODO EMagineException.e Not Implemented
//			DAOManager.rollBackTransaction();
//			e.printStackTrace();
//		}

		
	}
	
	@Override
	protected ExtractionDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getExtractionDAO();
	}
}
