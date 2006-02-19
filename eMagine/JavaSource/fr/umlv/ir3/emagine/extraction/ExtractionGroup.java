package fr.umlv.ir3.emagine.extraction;

import java.util.Collection;

/**
 * Represents a group of properties for an extraction entity form
 */
public interface ExtractionGroup {
	/**
	 * @return the properties of that group
	 */
	public Collection<String> getProperties();
	
	/**
	 * @return the groups contained in that group
	 */
	public Collection<ExtractionGroup> getGroups();
	/**
	 * @return the name of the group
	 */
	public String getGroupName();
}
