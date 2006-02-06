package fr.umlv.ir3.emagine.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpServletRequestAdapter implements SessionManagerConfig {
	HttpServletRequest request;
	
	public HttpServletRequestAdapter(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpSession getSession() {
		return request.getSession();
	}
	
	public EmaginePrincipal getUserPrincipal() throws SecurityFilterNotCorrectlyInitializedException {
		if (!(request.getUserPrincipal() instanceof EmaginePrincipal)) {
			throw new SecurityFilterNotCorrectlyInitializedException();
		}
		return (EmaginePrincipal)request.getUserPrincipal();
	}
}
