package fr.umlv.ir3.emagine.extraction;

import java.io.IOException;
import java.io.OutputStream;

import fr.umlv.ir3.emagine.util.EMagineException;

public class CSVExtractor implements Extractor {
	private boolean firstField;
	private OutputStream outputStream;

	public void extract(Extractable extractable, OutputStream outputStream)
			throws EMagineException {
		try {
			init(outputStream);
			
			// Extraction of each column title
			for (String columnTitle : extractable.getColumnTitles()) {
				writeValue(columnTitle);
			}
			endOfLine();

			// Extraction of each row
			for (ExtractableRow extractableRow : extractable.getRows()) {
				for (ExtractableCell extractableCell : extractableRow
						.getCells()) {
					Object value = extractableCell.getCellValue();
					writeValue(value);
				}
				endOfLine();
			}
		} catch (IOException e) {
			throw new EMagineException("exception.cvsExtractor.extract.error",
					e);
		}
	}
	
	private void init(OutputStream outputStream) {
		this.outputStream = outputStream;
		this.firstField = true;
	}
	
	private void endOfLine() throws IOException {
		outputStream.write("\r\n".getBytes());	// TODO voir pour le retour chariot local ? ou config user ...
		firstField = true;
	}

	private void writeValue(Object value)
			throws IOException {
		if (!firstField) {
			outputStream.write(",".getBytes());
		} else {
			firstField = false;
		}
		if (value != null) {
			String strValue = value.toString().replaceAll("\"", "\"\"");
			outputStream.write(("\""+strValue+"\"").getBytes());
		}
	}

}
