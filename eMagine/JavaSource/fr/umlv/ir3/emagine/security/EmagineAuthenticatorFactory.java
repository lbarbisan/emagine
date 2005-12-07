package fr.umlv.ir3.emagine.security;

import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;

import org.securityfilter.authenticator.Authenticator;
import org.securityfilter.authenticator.AuthenticatorFactory;
import org.securityfilter.authenticator.BasicAuthenticator;
import org.securityfilter.config.SecurityConfig;

public class EmagineAuthenticatorFactory extends AuthenticatorFactory {

	/**
	 * Create an Authenticator based on the specified configuration information.
	 * 
	 * @param filterConfig
	 * @param securityConfig
	 * @return
	 * @throws Exception
	 */
	@Override
	public static Authenticator createAuthenticator(FilterConfig filterConfig,
			SecurityConfig securityConfig) throws Exception {
		Authenticator authenticator = null;

		String authMethod = securityConfig.getAuthMethod();
		if (HttpServletRequest.FORM_AUTH.equals(authMethod)) {
			// FORM
			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// Emagine patch
			authenticator = new EmagineFormAuthenticator();
			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		} else if (HttpServletRequest.BASIC_AUTH.equals(authMethod)) {
			// BASIC
			authenticator = new BasicAuthenticator();
		} else {
			throw new Exception("No Authenticator available for auth method: "
					+ authMethod);
		}
		authenticator.init(filterConfig, securityConfig);
		return authenticator;
	}

}
