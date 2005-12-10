package fr.umlv.ir3.emagine.statistic;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.jfree.data.general.DefaultPieDataset;

import de.laures.cewolf.DatasetProduceException;
import de.laures.cewolf.DatasetProducer;
import fr.umlv.ir3.emagine.extraction.Extractable;
import fr.umlv.ir3.emagine.extraction.ExtractableCell;
import fr.umlv.ir3.emagine.extraction.ExtractableRow;
import fr.umlv.ir3.emagine.util.EMagineException;

/** 
 * An example data producer.
 * @author  Guido Laures 
 */
public class StatisticViewData implements DatasetProducer, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7528697318845329647L;
	private final Extractable datas;
    

    public StatisticViewData(Extractable datas) {
    	this.datas = datas;
    }
    

    public Object produceDataset(Map params) throws DatasetProduceException {
    	String type = (String) params.get("type"); 
    	DefaultPieDataset dataset = null;
    	
    	if(type.equals("Pie")) {
        	dataset = new DefaultPieDataset();
    	} else if(type.equals("VerticalBar")) {
        	dataset = new DefaultPieDataset();
    	} else if(type.equals("HorizontalBar")) {
        	dataset = new DefaultPieDataset();
    	} 
    	
        for (ExtractableRow row : datas.getRows()) {
        	for (ExtractableCell cell : row.getCells()) {
        		try {
					dataset.setValue(cell.getColumnName(), Integer.parseInt(cell.getCellValue().toString()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
					throw new DatasetProduceException();
				} catch (EMagineException e) {
					e.printStackTrace();
					throw new DatasetProduceException();
				}
        	}
		}
        
        return dataset;
    }

    /**
     * This producer's data is invalidated after 5 seconds. By this method the
     * producer can influence Cewolf's caching behaviour the way it wants to.
     */
	public boolean hasExpired(Map params, Date since) {		
		return false;
	}

	/**
	 * Returns a unique ID for this DatasetProducer
	 */
	public String getProducerId() {
		return "PageViewCountData DatasetProducer";
	}
}