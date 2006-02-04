package fr.umlv.ir3.emagine.extraction;

public interface ExtractableRow {
	/**
	 * Returns each cell of the row. The iteration must be in the same order as the title columns of the extractable.
	 * @return each cell of the row
	 */
	public Iterable<ExtractableCell> getCells();
}
