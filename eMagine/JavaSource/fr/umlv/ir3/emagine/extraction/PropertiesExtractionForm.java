/**
 *  
 */
package fr.umlv.ir3.emagine.extraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import fr.umlv.ir3.emagine.util.Bundles;

/**
 * @author netangel
 *
 */
public class PropertiesExtractionForm extends AbstractExtractionForm {

	private static final long serialVersionUID = -1457049539320560373L;

	protected String extractionEntityName;
	protected ExtractionGroup rootGroup;
	protected Collection<String> entityProperties;

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionForm#getExtractionObjectName()
	 */
	public String getExtractionObjectName() {
		return Bundles.getExtractionBundle().getString("extraction."+extractionEntityName+".sessionObject");
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionConfig#getEntityProperties()
	 */
	public Collection<String> getEntityProperties() {
		checkRootGroup();
		if (entityProperties == null) {
			entityProperties = new ArrayList<String>();
			addRecursiveEntityProperties(rootGroup);
		}
		return entityProperties;
	}

	/**
	 * Adds recursivly the entity properties of the specified group to the entityProperties variable
	 * @param group
	 */
	private void addRecursiveEntityProperties(ExtractionGroup group) {
		for (String property : group.getFullNameProperties()) {
			entityProperties.add(property);
		}
		for (ExtractionGroup childGroup : group.getGroups()) {
			addRecursiveEntityProperties(childGroup);
		}
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionConfig#getExtractionEntityName()
	 */
	public String getExtractionEntityName() {
		return extractionEntityName;
	}

	/**
	 * @param extractionEntityName The extractionEntityName to set.
	 */
	public void setExtractionEntityName(String extractionEntityName) {
		if(!extractionEntityName.equals(this.extractionEntityName)) {
			// The new extraction entity name is different.
			// Deleting the cached properties and root group
			rootGroup = null;
			entityProperties = null;
			this.extractionEntityName = extractionEntityName;
		}
	}

	public String getExtractionTitleKey() {
		return "extraction."+extractionEntityName+".title";
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionShowForm#getExtractionGroups()
	 */
	public Collection<ExtractionGroup> getExtractionGroups() {
		checkRootGroup();
		return rootGroup.getGroups();
	}
	
	private void checkRootGroup() {
		if (rootGroup == null) {
			rootGroup = new PropertiesExtractionGroup("", extractionEntityName, "");
		}
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionShowForm#getRootGroup()
	 */
	public ExtractionGroup getRootGroup() {
		return rootGroup;
	}

	public class GroupFinishedIterators {
		private final ExtractionGroup group;
		private final List<Iterator<ExtractionGroup>> finishedIterator;
		public GroupFinishedIterators(final ExtractionGroup group, final List<Iterator<ExtractionGroup>> finishedIterator) {
			this.group = group;
			this.finishedIterator = finishedIterator;
		}
		public ExtractionGroup getGroup() {
			return group;
		}
		public List<Iterator<ExtractionGroup>> getFinishedIterator() {
			return finishedIterator;
		}
	}

	public Iterator<GroupFinishedIterators> getExtractionGroupIterator() {
		checkRootGroup();
		// Create the first node : rootGroup
		final Stack<Iterator<ExtractionGroup>> rootStack = new Stack<Iterator<ExtractionGroup>>();
		final ArrayList<ExtractionGroup> rootGroupList = new ArrayList<ExtractionGroup>();
		rootGroupList.add(rootGroup);
		rootStack.push(rootGroupList.iterator());

		return new Iterator<GroupFinishedIterators>() {
			final private Stack<Iterator<ExtractionGroup>> iterators = rootStack;
			private LinkedList<Iterator<ExtractionGroup>> currentFinishedIterators = new LinkedList<Iterator<ExtractionGroup>>();

			public boolean hasNext() {
				return getAvailableIterator() != null;
			}
			public GroupFinishedIterators next() {
				final ExtractionGroup group = nextExtractionGroup();

				final List<Iterator<ExtractionGroup>> returnFinished = this.currentFinishedIterators;
				this.currentFinishedIterators = new LinkedList<Iterator<ExtractionGroup>>();
				return new GroupFinishedIterators(group, returnFinished);
			}
			public void remove() {
				throw new NotImplementedException();
			}
			private ExtractionGroup nextExtractionGroup() {
				Iterator<ExtractionGroup> iterator = getAvailableIterator();
				if (iterator != null) {
					// retreive the next object for current iterator
					ExtractionGroup group = iterator.next();
					if (group != null) {
						// Try to push the iterator of the sub-groups if any
						iterator = group.getGroups().iterator();
						if (iterator != null && iterator.hasNext()) {
							// that object contains another collection on which we will iterate the next time
							// we save the current iterator
							iterators.push(iterator);
						} else {
							currentFinishedIterators.add(iterator);
						}
					}
					// Determine the next available iterator
					getAvailableIterator();
					return group;
				}
				throw new NoSuchElementException();
			}
			private Iterator<ExtractionGroup> getAvailableIterator() {
				if (!iterators.isEmpty()) {
					Iterator<ExtractionGroup> iterator = iterators.peek();
					if (iterator.hasNext()) {
						// the iterator is available (it contains at least one value)
						return iterator;
					} else {
						// else the iterator is finished, cycle to get an available one
						currentFinishedIterators.add(iterators.pop());
						return getAvailableIterator();
					}
				}
				return null;
			}
		};
	}
}
