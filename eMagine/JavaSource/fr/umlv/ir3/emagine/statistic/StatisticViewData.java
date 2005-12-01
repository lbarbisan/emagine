package fr.umlv.ir3.emagine.statistic;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.jfree.data.general.DefaultPieDataset;

import de.laures.cewolf.DatasetProduceException;
import de.laures.cewolf.DatasetProducer;
import fr.umlv.ir3.emagine.util.Extractable;

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
    	
        for (Iterable<Object> row : datas) {
			Iterator obj = row.iterator();
			dataset.setValue(obj.next().toString(),Integer.parseInt(obj.next().toString()));
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