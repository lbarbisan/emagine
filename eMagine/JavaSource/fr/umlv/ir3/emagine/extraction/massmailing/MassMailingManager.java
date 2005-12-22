package fr.umlv.ir3.emagine.extraction.massmailing;

import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;

public class MassMailingManager extends EditableManagerImpl<MassMailing, MassMailingDAO> {

	@Override
	protected MassMailingDAO getDAO() {
		return DAOManager.getInstance().getMassMailingDAO();
	}
	
	//TODO : CRUD
	//Use case « créer un publipostage »
	//Use case « supprimer un publipostage »
	//Use case « mettre à jour un publipostage »
	//Use case « charger un publipostage »
	
}
