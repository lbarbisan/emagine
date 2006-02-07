package fr.umlv.ir3.emagine.extraction;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.EMagineException;

public class ObjectListExtractable<O> implements Extractable {
	private final List<O> objectList;
	private final List<String> columns;
	private final List<String> columnTitles;

	/**
	 * @param objectList
	 * @param columns constructor
	 */
	public ObjectListExtractable(List<O> objectList, Collection<String> selectedColumns) {
		this.columnTitles = new ArrayList<String>();
		// The titles have not been retreived. Retreive them from the message bundle
		// Save an array of the keys we retreive in order to iterate on the columns in the same order as the column titles will be iterated
		this.columns = new ArrayList<String>();
		for (String columnKey : selectedColumns) {
			columnTitles.add(Bundles.getMessageResources().getMessage("form."+columnKey));
			columns.add(columnKey);
		}
		this.objectList = objectList;
	}

	public List<String> getColumnTitles() {
		return columnTitles;
	}

	public Iterable<ExtractableRow> getRows() {
		return new Iterable<ExtractableRow>() {
			public Iterator<ExtractableRow> iterator() {
				return new ObjectListExtractableRowIterator(objectList.iterator());
			}
		};
	}
	
	private class ObjectListExtractableRowIterator implements Iterator<ExtractableRow> {
		private Iterator<O> iterator;
		public ObjectListExtractableRowIterator(Iterator<O> iterator) {
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
		private final O entity;
		public ObjectListExtractableRow(O entity) {
			this.entity = entity;
		}

		public Iterable<ExtractableCell> getCells() {
			return new Iterable<ExtractableCell>() {
				public Iterator<ExtractableCell> iterator() {
					return new ObjectListExtractableCellIterator(columns.iterator());
				}
			};
		}
		
		private class ObjectListExtractableCellIterator implements Iterator<ExtractableCell> {
			private Iterator<String> columnsIterator;
			public ObjectListExtractableCellIterator(Iterator<String> selectedColumnsIterator) {
				this.columnsIterator = selectedColumnsIterator;
			}
			public boolean hasNext() {
				return columnsIterator.hasNext();
			}

			public ExtractableCell next() {
				return new ObjectListExtractableCell(columnsIterator.next());
			}

			public void remove() {
				columnsIterator.remove();
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
					}//TODO : avec un booléen ça plante
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
