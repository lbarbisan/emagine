package fr.umlv.ir3.emagine.security;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.securityfilter.authenticator.FormAuthenticator;
import org.securityfilter.filter.SecurityFilter;
import org.securityfilter.filter.SecurityRequestWrapper;


public class EmagineFormAuthenticator extends FormAuthenticator {

	/**
	 * Process any login information that was included in the request, if any.
	 * Returns true if SecurityFilter should abort further processing after the
	 * method completes (for example, if a redirect was sent as part of the
	 * login processing).
	 * 
	 * @param request
	 * @param response
	 * @return true if the filter should return after this method ends, false
	 *         otherwise
	 */
	@Override
	public boolean processLogin(SecurityRequestWrapper request,
			HttpServletResponse response) throws Exception {

		// process any persistent login information, if user is not already
		// logged in,
		// persistent logins are enabled, and the persistent login info is
		// present in this request
		if (request.getRemoteUser() == null && persistentLoginManager != null
				&& persistentLoginManager.rememberingLogin(request)) {
			String username = persistentLoginManager.getRememberedUsername(
					request, response);
			String password = persistentLoginManager.getRememberedPassword(
					request, response);
			Principal principal = realm.authenticate(username, password);
			if (principal != null) {
				request.setUserPrincipal(principal);
			} else {
				// failed authentication with remembered login, better forget
				// login now
				persistentLoginManager.forgetLogin(request, response);
			}
		}

		// process login form submittal
		if (request.getMatchableURL().endsWith(loginSubmitPattern)) {
			String username = request.getParameter(FORM_USERNAME);
			String password = request.getParameter(FORM_PASSWORD);
			Principal principal = realm.authenticate(username, password);

			if (principal != null) {
				// login successful

				// invalidate old session if the user was already authenticated,
				// and they logged in as a different user
				if (request.getUserPrincipal() != null
						&& !username.equals(request.getRemoteUser())) {
					request.getSession().invalidate();
				}

				// manage persistent login info, if persistent login management
				// is enabled
				if (persistentLoginManager != null) {
					String rememberme = request.getParameter(FORM_REMEMBERME);
					// did the user request that their login be persistent?
					if (rememberme != null) {
						// remember login
						persistentLoginManager.rememberLogin(request, response,
								username, password);
					} else {
						// forget login
						persistentLoginManager.forgetLogin(request, response);
					}
				}

				request.setUserPrincipal(principal);
				// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				// Emagine patch
				SessionManager.getInstance().login(principal, username, password, request.getSession());
				// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				String continueToURL = getContinueToURL(request);
				// This is the url that the user was initially accessing before
				// being prompted for login.
				response
						.sendRedirect(response.encodeRedirectURL(continueToURL));
			} else {
				// login failed
				// set response status and forward to error page
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				request.getRequestDispatcher(errorPage).forward(request,
						response);
			}
			return true;
		}

		return false;
	}

	/**
	 * FormAuthenticator has a special case where the user should be sent to a
	 * default page if the user spontaneously submits a login request.
	 * 
	 * @param request
	 * @return a URL to send the user to after logging in
	 */
	private String getContinueToURL(HttpServletRequest request) {
		String savedURL = SecurityFilter.getContinueToURL(request);
		if (savedURL != null) {
			return savedURL;
		} else {
			return request.getContextPath() + defaultPage;
		}
	}

}
