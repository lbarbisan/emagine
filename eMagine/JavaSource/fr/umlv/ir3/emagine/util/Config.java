package fr.umlv.ir3.emagine.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Config {
	public static ResourceBundle resourceBundle;
	public static synchronized ResourceBundle getResourceBundle() throws EMagineException {
		if (resourceBundle == null) {
			try {
			resourceBundle = new PropertyResourceBundle(new FileInputStream("eMagine.properties"));
			} catch (FileNotFoundException e) {
				throw new EMagineException("exception.config.resourceBundleInitError", e);
			} catch (IOException e) {
				throw new EMagineException("exception.config.resourceBundleInitError", e);
			}
		}
		return resourceBundle;
	}

}
