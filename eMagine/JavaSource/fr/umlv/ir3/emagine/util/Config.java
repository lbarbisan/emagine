package fr.umlv.ir3.emagine.util;

import java.util.ResourceBundle;

public class Config {
	public static ResourceBundle resourceBundle;
	public static synchronized ResourceBundle getResourceBundle() throws EMagineException {
		if (resourceBundle == null) {
			try {
				resourceBundle = ResourceBundle.getBundle("fr.umlv.ir3.emagine.ressource.eMagine"); // Package.getPackage("fr.umlv.ir3.emagine.ressource") new PropertyResourceBundle(new FileInputStream("eMagine.properties"));
			} finally {
				
			}
		}
		return resourceBundle;
	}

}
