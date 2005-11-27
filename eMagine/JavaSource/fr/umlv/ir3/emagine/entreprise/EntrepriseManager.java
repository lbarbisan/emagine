package fr.umlv.ir3.emagine.entreprise;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class EntrepriseManager {

	/**
	 * Create a new entreprise with the given Entreprise
	 * @param entreprise the entreprise to create
	 * @throws EMagineException if the login already exists, or if there is an SQL exception
	 */
	public void createEntreprise(Entreprise entreprise) throws EMagineException {
		// Create the new Entreprise
		DAOManager.beginTransaction();
		try {
			// TODO : createEntreprise : vérif login unique
			getDAO().create(entreprise);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Update the given Entreprise
	 * @param entreprise the entreprise to update
	 * @throws EMagineException if the login already exists for another id, or if there is an SQL exception
	 */
	public void updateEntreprise(Entreprise entreprise) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			// TODO : modifyEntreprise : vérif droits. si pas droits de modif, enregistrer patch + envoyer event
			// TODO : modifyEntreprise : vérif login unique
			getDAO().update(entreprise);
			// TODO : modifyEntreprise : Mail

			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Delete a list of entreprises.
	 * @param entreprises The list of entreprises to be deleted
	 * @param force Force the deletion, even if one entreprise is connected
	 * @throws EMagineException if one of those entreprises doesn't exist in the database, or if one of them is connected and the force switch is false
	 */
	public void deleteEntreprises(List<Entreprise> entreprises, boolean force) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			// TODO : gérer les entreprise connectés, notamment, supprimer ceux qui sont pas connectés, et question sur les autres ? ...
			getDAO().deleteEntreprises(entreprises);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public List<Entreprise> getEntreprises(EntrepriseSearchParam entrepriseSearchParam) throws EMagineException {
		// TODO : getEntreprises javadoc
		return getDAO().getEntreprises(entrepriseSearchParam);
	}

	private EntrepriseDAO getDAO() {
		return DAOManager.getInstance().getEntrepriseDAO();
	}

}
