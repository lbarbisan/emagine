package fr.umlv.ir3.emagine.extraction;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class ExtractionManager extends BaseManagerImpl<Extraction, ExtractionDAO> {


	/**
	 * Return Selected Columns for spécified User and Specified View
	 */
	//TODO : Use case « Configurer l'extraction d'une liste »
	public List<String> getSelectedColumns(ExtractionParam extractionParam)  
	{
		ExtractionDAO extractionDAO = getDAO(); 
		try {
			Extraction extraction = extractionDAO.find(extractionParam);
			return extraction.getColumns();
		} catch (EMagineException e) {
			// TODO EMagineException.e Not Implemented
			e.printStackTrace();
		}
		
		return null; 
	}

	
	public void setColumns(Extraction extraction, List<String> columns)  
	{
		DAOManager.beginTransaction();
		try {
			extraction.setColumns(columns);
			getDAO().update(extraction);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			// TODO EMagineException.e Not Implemented
			DAOManager.rollBackTransaction();
			e.printStackTrace();
		}

		
	}


	@Override
	public Extraction retrieve(long id) throws EMagineException {
		// TODO ExtractionManager.retrieve()
		return null;
	}


	@Override
	protected ExtractionDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getExtractionDAO();
	}
}
