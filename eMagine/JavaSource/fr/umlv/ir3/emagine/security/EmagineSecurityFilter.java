package fr.umlv.ir3.emagine.security;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.securityfilter.config.SecurityConfig;
import org.securityfilter.config.SecurityConstraint;
import org.securityfilter.config.WebResourceCollection;
import org.securityfilter.filter.SecurityFilter;
import org.securityfilter.filter.URLPattern;
import org.securityfilter.filter.URLPatternFactory;
import org.securityfilter.realm.SecurityRealmInterface;

import fr.umlv.ir3.emagine.util.EMagineException;

public class EmagineSecurityFilter extends SecurityFilter {
	private static EmagineSecurityFilter instance;

	/**
	 * Initialize the SecurityFilter.
	 *
	 * @param config filter configuration object
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		try {
			// parse config file

			// config file name
			String configFile = config.getInitParameter(CONFIG_FILE_KEY);
			if (configFile == null) {
				configFile = DEFAULT_CONFIG_FILE;
			}
			URL configURL = config.getServletContext().getResource(configFile);

			// validate config file?
			boolean validate = TRUE.equalsIgnoreCase(config
					.getInitParameter(VALIDATE_KEY));

			SecurityConfig securityConfig = new SecurityConfig(validate);
			securityConfig.loadConfig(configURL);

			// get the realm
			realm = securityConfig.getRealm();

			// create an Authenticator
			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// Emagine patch
			authenticator = EmagineAuthenticatorFactory.createAuthenticator(config,
					securityConfig);
			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

			// create pattern list
			patternFactory = new URLPatternFactory();
			patternList = new ArrayList();
			int order = 1;
			List constraints = securityConfig.getSecurityConstraints();
			for (Iterator cIter = constraints.iterator(); cIter.hasNext();) {
				SecurityConstraint constraint = (SecurityConstraint) cIter
						.next();
				for (Iterator rIter = constraint.getWebResourceCollections()
						.iterator(); rIter.hasNext();) {
					WebResourceCollection resourceCollection = (WebResourceCollection) rIter
							.next();
					for (Iterator pIter = resourceCollection.getURLPatterns()
							.iterator(); pIter.hasNext();) {
						URLPattern pattern = patternFactory.createURLPattern(
								(String) pIter.next(), constraint,
								resourceCollection, order++);
						patternList.add(pattern);
					}
				}
			}
			Collections.sort(patternList);
			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// Emagine patch
			instance = this;
			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		} catch (java.io.IOException ioe) {
			System.err.println("unable to parse input: " + ioe);
		} catch (org.xml.sax.SAXException se) {
			System.err.println("unable to parse input: " + se);
		} catch (Exception e) {
			System.err.println("error: " + e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the instance of the security filter.
	 * @return
	 * @throws EMagineException if the security filter has not been initialized
	 */
	public static EmagineSecurityFilter getInstance() throws EMagineException {
		if (instance == null) {
			throw new EMagineException("exception.eMagineSecurityFilter.notInitialized");
		}
		return instance;
	}

	/**
	 * Gets the emagine security filter's realm
	 * @return
	 */
	public SecurityRealmInterface getRealm() {
		return realm;
	}

}
