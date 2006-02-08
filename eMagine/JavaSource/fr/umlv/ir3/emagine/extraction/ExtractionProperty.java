package fr.umlv.ir3.emagine.extraction;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * This class represents a property of an extraction type. It contains all the users that have chosen this property the last time they exported that extraction entity.
 * @author eMagine
 */
@Entity(access = AccessType.FIELD)
public class ExtractionProperty extends BaseEntity {

	private static final long serialVersionUID = 3409810203639153702L;

	private String name;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "extractionEntity_id")
	private ExtractionEntity extractionEntity;

	protected ExtractionProperty() {
	}
	
	public ExtractionProperty(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the extractionEntity.
	 */
	public ExtractionEntity getExtractionEntity() {
		return extractionEntity;
	}

	/**
	 * @param extractionEntity The extractionEntity to set.
	 */
	public void setExtractionEntity(ExtractionEntity extractionEntity) {
		this.extractionEntity = extractionEntity;
	}

}
