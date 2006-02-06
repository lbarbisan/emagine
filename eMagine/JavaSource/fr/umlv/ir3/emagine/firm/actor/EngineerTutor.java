package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.Apprentice;

/**
 * 
 * @author Administrateur
 *@persitence Terminé
 */
@Entity(access = AccessType.FIELD)
public class EngineerTutor extends FirmActor {
	
	private static final long serialVersionUID = 3857030644896914550L;

	@OneToMany(	mappedBy = "engineerTutor")
	@Cascade(CascadeType.SAVE_UPDATE)
			private List<Apprentice> apprentice;
	
	public List<Apprentice> getApprentice() {
		return apprentice;
	}
	
	public void setApprentice(List<Apprentice> apprentice) {
		this.apprentice = apprentice;
	}
	
}
