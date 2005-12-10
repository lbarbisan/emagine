package fr.umlv.ir3.emagine.extraction;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import fr.umlv.ir3.emagine.util.EMagineException;

public class XLSExtractor implements Extractor {

	public void extract(Extractable extractable, OutputStream outputStream) throws EMagineException {
		final HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("export");
		HSSFRow row = sheet.createRow((short) 0);

		// Extraction of each column title
		short i = 0;
		for (String columnTitle : extractable.getColumnTitles()) {
			row.createCell(i++).setCellValue(
					columnTitle);
		}

		// Extraction of each row
		i = 1;
		for (ExtractableRow extractableRow : extractable.getRows()) {
			// Cr�ation d'une nouvelle ligne dans la feuille
			row = sheet.createRow(i++);
			short j = 0;
			for (ExtractableCell extractableCell : extractableRow.getCells()) {
				Object value = extractableCell.getCellValue();
				if (value != null) {
					HSSFCell cell = row.createCell(j);
					try {
						cell.getClass().getMethod("setCellValue", value.getClass()).invoke(cell, value);
					} catch (IllegalArgumentException e) {
						throw new EMagineException("exception.xlsExtractor.extract.error", e);
					} catch (SecurityException e) {
						throw new EMagineException("exception.xlsExtractor.extract.error", e);
					} catch (IllegalAccessException e) {
						throw new EMagineException("exception.xlsExtractor.extract.error", e);
					} catch (InvocationTargetException e) {
						throw new EMagineException("exception.xlsExtractor.extract.error", e);
					} catch (NoSuchMethodException e) {
						throw new EMagineException("exception.xlsExtractor.extract.error", e);
					}
				}
				++j;
			}
		}
		try {
			wb.write(outputStream);
		} catch (IOException e) {
			throw new EMagineException("exception.xlsExtractor.extract.error", e);
		}
//		try {
//			for (Object objectRow : extractable.getRows()) {
//				// Cr�ation d'une nouvelle ligne dans la feuille
//				row = sheet.createRow(i++);
//				short j = 0;
//				for (String field : fields) {
//					Object value = objectRow.getClass().getMethod("get"+field.substring(0, 1).toUpperCase()+field.substring(1)).invoke(objectRow);	// TODO : r�fl�chir � la mani�re d'impl�menter cela sans appel... � mettre dans l'interface ? Peut-�tre sous forme de getter prenant en param�tre un entier de colone...
//					// cr�ation de la case et export de sa valeur (suivant son type)
//					if (value != null) {
//						if (value instanceof Date) {
//							row.createCell(j).setCellValue((Date) value);
//						} else if (value instanceof Boolean) {
//							row.createCell(j).setCellValue((Boolean) value);
//						} else if (value instanceof BigDecimal) {
//							row.createCell(j).setCellValue(
//									((BigDecimal) value).doubleValue());
//						} else if (value instanceof Integer) {
//							row.createCell(j).setCellValue((Integer) value);
//						} else if (value instanceof Long) {
//							row.createCell(j).setCellValue((Long) value);
//						} else if (value instanceof Double) {
//							row.createCell(j).setCellValue((Double) value);
//						} else {
//							row.createCell(j)
//									.setCellValue(value.toString());
//						}
//					}
//					++j;
//				}
//			}
//			wb.write(outputStream);
//		} catch (IllegalArgumentException e) {
//			throw new EMagineException("exception.extraction.xlsExtractor.extractError", e);
//		} catch (SecurityException e) {
//			throw new EMagineException("exception.extraction.xlsExtractor.extractError", e);
//		} catch (IllegalAccessException e) {
//			throw new EMagineException("exception.extraction.xlsExtractor.extractError", e);
//		} catch (InvocationTargetException e) {
//			throw new EMagineException("exception.extraction.xlsExtractor.extractError", e);
//		} catch (NoSuchMethodException e) {
//			throw new EMagineException("exception.extraction.xlsExtractor.extractError", e);
//		} catch (IOException e) {
//			throw new EMagineException("exception.extraction.xlsExtractor.extractError", e);
//		}
	}

}
