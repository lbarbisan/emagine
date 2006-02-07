package fr.umlv.ir3.emagine.extraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * This class is the implementation of an ExtractionConfig. It is used to  
 * @author aogier
 *
 */
@Entity(access = AccessType.FIELD)
public class ExtractionConfigEntity extends BaseEntity implements
		ExtractionConfig {

	private static final long serialVersionUID = 353837005995453550L;

	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	private ExtractionEntity extractionEntity;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "extractionconfig_id")
	private User user;

	private ExtractionType extractionType;

	@ManyToMany()
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<ExtractionProperty> selectedExtractionProperties;


	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionConfig#getEntityProperties()
	 */
	public Collection<String> getEntityProperties() {
		ArrayList<String> properties = new ArrayList<String>();
		for (ExtractionProperty property : extractionEntity.getProperties()) {
			properties.add(property.getName());
		}
		return properties;
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionConfig#getExtractionEntityName()
	 */
	public String getExtractionEntityName() {
		return extractionEntity.getName();
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionConfig#getExtractionType()
	 */
	public ExtractionType getExtractionType() {
		return extractionType;
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionConfig#getSelectedEntityProperties()
	 */
	public String[] getSelectedEntityProperties() {
		ArrayList<String> properties = new ArrayList<String>();
		for (ExtractionProperty property : selectedExtractionProperties) {
			properties.add(property.getName());
		}
		return properties.toArray(new String[properties.size()]);
	}

	/**
	 * @return Returns the user.
	 */
	public User getUser() {
		return user;
	}

}
