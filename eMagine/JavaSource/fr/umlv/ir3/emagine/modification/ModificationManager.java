package fr.umlv.ir3.emagine.modification;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class ModificationManager extends BaseManager<Modification, ModificationDAO> {

	public static void askForModification() {
		// TODO : ModificationManager.askForModification
	}
	
	@Override
	protected ModificationDAO getDAO() {
		return DAOManager.getInstance().getModificationDAO();
	}

}
