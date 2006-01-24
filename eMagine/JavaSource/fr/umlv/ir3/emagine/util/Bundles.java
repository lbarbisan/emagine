package fr.umlv.ir3.emagine.util;

import java.util.ResourceBundle;

import org.apache.struts.util.MessageResources;

/**
 * General purpose class that is used to retrieve the bundles of eMagine application.
 * <p>
 * To get a specific parameter (<i>param</i>) of eMagine application, call :
 * <code>Bundles.getConfigBundle().getString(<i>param</i>)</code>
 * <p>
 * To get a specific message (<i>msgId</i>) for eMagine application, call :
 * <code>Bundles.getMessageResources().getMessage(<i>msgId</i>)</code> 
 * 
 * @version $Rev: $ $Date: $ $User: $
 */
public class Bundles {
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("fr.umlv.ir3.emagine.ressource.eMagine");
	private static MessageResources messageResources = MessageResources.getMessageResources("fr.umlv.ir3.emagine.ressource.ressources");
	
	
	public static ResourceBundle getConfigBundle() {
		return resourceBundle;
	}
	
	public static MessageResources getMessageResources() {
		return messageResources;
	}
	
	public static String fillRessource(String resourceName, String... replacment)
	{
		ResourceBundle bundle = Bundles.getConfigBundle();
    	String resource = bundle.getString(resourceName);
    	
    	for(int index=0; index < replacment.length; index++)
    	{
    		resource = resource.replace("{" + index  + "}" , replacment[index]);
    	}
		return resource;
	}

}
