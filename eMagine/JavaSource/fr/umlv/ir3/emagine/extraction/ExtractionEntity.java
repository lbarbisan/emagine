package fr.umlv.ir3.emagine.extraction;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * This class represents an extraction type. It contains a list of properties that can be exported.
 * @author eMagine
 */
@Entity(access = AccessType.FIELD)
public class ExtractionEntity extends BaseEntity {

	private static final long serialVersionUID = 2662004301602604497L;

	@OneToMany(mappedBy = "property")
	@Cascade(CascadeType.ALL)
	@Column(unique = true)
	private List<ExtractionProperty> properties;
	
	private String name;

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
	 * @return Returns the properties.
	 */
	public List<ExtractionProperty> getProperties() {
		return properties;
	}

	/**
	 * @param properties The properties to set.
	 */
	public void setProperties(List<ExtractionProperty> properties) {
		this.properties = properties;
	}
}