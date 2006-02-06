package fr.umlv.ir3.emagine.security;

import javax.servlet.http.HttpServletResponse;

import org.securityfilter.authenticator.FormAuthenticator;
import org.securityfilter.filter.SecurityRequestWrapper;

public class EmagineAuthenticator extends FormAuthenticator {

	@Override
	public boolean processLogin(SecurityRequestWrapper request, HttpServletResponse response) throws Exception {
		final boolean abort = super.processLogin(request, response);
		if (request.getUserPrincipal() != null && request.getUserPrincipal() instanceof EmaginePrincipal) {
			SessionManager.getInstance().initThreadLocal(new HttpServletRequestAdapter(request));
		}
		return abort;
	}

}
