package fr.umlv.ir3.emagine.extraction;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

public class ObjectListExtractable<Entity extends BaseEntity> implements Extractable {
	private final List<Entity> objectList;
	private final Collection<String> selectedColumns;

	/**
	 * @param objectList
	 * @param selectedColumns constructor
	 */
	public ObjectListExtractable(List<Entity> objectList, Collection<String> selectedColumns) {
		this.objectList = objectList;
		this.selectedColumns = selectedColumns;
	}

	public Collection<String> getColumnTitles() {
		return selectedColumns;	// TODO : aller récupérer les noms des colonnes dans le properties
	}

	public Iterable<ExtractableRow> getRows() {
		return new Iterable<ExtractableRow>() {
			public Iterator<ExtractableRow> iterator() {
				return new ObjectListExtractableRowIterator(objectList.iterator());
			}
		};
	}
	
	private class ObjectListExtractableRowIterator implements Iterator<ExtractableRow> {
		private Iterator<Entity> iterator;
		public ObjectListExtractableRowIterator(Iterator<Entity> iterator) {
			this.iterator = iterator;
		}
		public boolean hasNext() {
			return iterator.hasNext();
		}

		public ExtractableRow next() {
			return new ObjectListExtractableRow(iterator.next());
		}

		public void remove() {
			iterator.remove();
		}
	}
	
	private class ObjectListExtractableRow implements ExtractableRow {
		private final Entity entity;
		public ObjectListExtractableRow(Entity entity) {
			this.entity = entity;
		}

		public Iterable<ExtractableCell> getCells() {
			return new Iterable<ExtractableCell>() {
				public Iterator<ExtractableCell> iterator() {
					return new ObjectListExtractableCellIterator(selectedColumns.iterator());
				}
			};
		}
		
		private class ObjectListExtractableCellIterator implements Iterator<ExtractableCell> {
			private Iterator<String> selectedColumnsIterator;
			public ObjectListExtractableCellIterator(Iterator<String> selectedColumnsIterator) {
				this.selectedColumnsIterator = selectedColumnsIterator;
			}
			public boolean hasNext() {
				return selectedColumnsIterator.hasNext();
			}

			public ExtractableCell next() {
				return new ObjectListExtractableCell(selectedColumnsIterator.next());
			}

			public void remove() {
				selectedColumnsIterator.remove();
			}
			
			private class ObjectListExtractableCell implements ExtractableCell {
				private String columnName;
				public ObjectListExtractableCell(String columnName) {
					this.columnName = columnName;
				}
				public Object getCellValue() throws EMagineException {
					String[] properties = columnName.split("\\.");
					Object currentObject = entity;
					// Itération sur chaque champs de la colonne
					for (String property : properties) {
						final String getterMethod = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
						// Invocation du getter de la propriété de la classe courrante. On garde le sous objet renvoyé.
						try {
							currentObject = currentObject.getClass().getMethod(getterMethod, (Class[])null).invoke(currentObject, (Object[])null);
						} catch (IllegalArgumentException e) {
							throw new EMagineException("exception.objectListExtractable.cellValueError", e);
						} catch (SecurityException e) {
							throw new EMagineException("exception.objectListExtractable.cellValueError", e);
						} catch (IllegalAccessException e) {
							throw new EMagineException("exception.objectListExtractable.cellValueError", e);
						} catch (InvocationTargetException e) {
							throw new EMagineException("exception.objectListExtractable.cellValueError", e);
						} catch (NoSuchMethodException e) {
							throw new EMagineException("exception.objectListExtractable.cellValueError", e);
						}
					}
					// On se retrouve avec la propriété finale demandée
					return currentObject;
				}
				public String getColumnName() {
					return columnName;
				}
			}
			
		}
	}
	


}
