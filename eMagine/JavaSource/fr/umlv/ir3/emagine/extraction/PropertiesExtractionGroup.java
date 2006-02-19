package fr.umlv.ir3.emagine.extraction;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.util.Bundles;

public class PropertiesExtractionGroup implements ExtractionGroup {
	private String groupName;
	private String groupType;
	private String parentsPathName;
	private Collection<ExtractionGroup> groups;
	private Collection<String> properties = new ArrayList<String>();
	public PropertiesExtractionGroup(String groupName, String groupType, String parentsPathName) {
		this.groupName = groupName;
		this.groupType = groupType;
		this.parentsPathName = parentsPathName;
	}
	public Collection<ExtractionGroup> getGroups() {
		if (groups == null) {
			parse();
		}
		return groups;
	}
	public Collection<String> getProperties() {
		if (properties == null) {
			parse();
		}
		return properties;
	}
	private void parse() {
		groups = new ArrayList<ExtractionGroup>();
		for (String property : Bundles.getExtractionBundle().getString("extraction."+groupType+".properties").split(",")) {
			String groupSliced[] = property.split(":");
			if (groupSliced.length > 1) {
				// the property name is followed by ':', so we have a group
				if ("".equals(groupSliced[0])) {
					// The current entity extends the given group
					// Retreive the groups of that group, and the properties of that group to add them to this groups and properties
					PropertiesExtractionGroup group = new PropertiesExtractionGroup(groupName, "group."+groupSliced[1], getPath(parentsPathName));
					properties.addAll(group.getProperties());
					groups.addAll(group.getGroups());
				} else {
					PropertiesExtractionGroup group = new PropertiesExtractionGroup(groupSliced[0], "group."+groupSliced[1], getPath(parentsPathName)+groupName);
					groups.add(group);
				}
			} else {
				// we have a new property
				properties.add(groupSliced[0]);
			}
		}
	}
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param property
	 * @return the full name of the specified property (the parents path name followed by the property name)
	 */
	public String getFullNameProperty(String property) {
		return getPath(parentsPathName)+getPath(groupName)+property;
	}
	private String getPath(String path) {
		return "".equals(path)?"":path+".";
	}
}
