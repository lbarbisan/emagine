package fr.umlv.ir3.emagine.ressource;

import java.security.Principal;

import servletunit.HttpSessionSimulator;
import servletunit.ServletContextSimulator;
import fr.umlv.ir3.emagine.security.EmaginePrincipal;
import fr.umlv.ir3.emagine.security.SecurityFilterNotCorrectlyInitializedException;
import fr.umlv.ir3.emagine.security.SecurityFilterNotInitializedException;
import fr.umlv.ir3.emagine.security.SessionManager;
import fr.umlv.ir3.emagine.security.SessionManagerConfig;
import fr.umlv.ir3.emagine.user.User;

public class DefaultLogin {

	public static void login() throws SecurityFilterNotCorrectlyInitializedException, SecurityFilterNotInitializedException {
		SessionManager.getInstance().initThreadLocal(
				new SessionManagerConfig() {
					public javax.servlet.http.HttpSession getSession() {
						return new HttpSessionSimulator(
								new ServletContextSimulator());
					};

					public fr.umlv.ir3.emagine.security.EmaginePrincipal getUserPrincipal()
							throws fr.umlv.ir3.emagine.security.SecurityFilterNotCorrectlyInitializedException {
						return new EmaginePrincipal() {
							public String getName() {
								return "InitDB";
							};

							public java.security.Principal getPrincipal() {
								return new Principal() {
									public String getName() {
										return "InitDB";
									};
								};
							};

							public User getUser() {
								User user = new User();
								user.setLogin("InitDB");
								return user;
							};
						};
					};

				});
	}
}
