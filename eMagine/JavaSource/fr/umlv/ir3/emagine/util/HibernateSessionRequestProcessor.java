package fr.umlv.ir3.emagine.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.tiles.TilesRequestProcessor;

public class HibernateSessionRequestProcessor extends TilesRequestProcessor {

	/**
	 * @see org.apache.struts.action.RequestProcessor#destroy()
	 */
	@Override
	public void destroy() {
		super.destroy();
		HibernateUtils.closeSession();
	}

	/**
	 * @see org.apache.struts.action.RequestProcessor#init(org.apache.struts.action.ActionServlet, org.apache.struts.config.ModuleConfig)
	 */
	@Override
	public void init(ActionServlet arg0, ModuleConfig arg1) throws ServletException {
		HibernateUtils.getSession();
		super.init(arg0, arg1);
		
	}

	/**
	 * @see org.apache.struts.tiles.TilesRequestProcessor#doForward(java.lang.String, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doForward(String arg0, HttpServletRequest arg1, HttpServletResponse arg2) throws IOException, ServletException {
		HibernateUtils.getSession();
		super.doForward(arg0, arg1, arg2);
		HibernateUtils.closeSession();
	}

}
