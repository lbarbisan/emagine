<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="form.administration"/></h2>
<ul>
	<li><html:link action="/userSearch?dispatch=show"><bean:message key="user.search.title"/></html:link></li>
	<li><html:link action="/userCreate?dispatch=show"><bean:message key="user.create.title"/></html:link></li>
	<li><html:link action="/profileList?dispatch=show"><bean:message key="profil.list.title"/></html:link></li>
	<li><html:link action="/profileCreate"><bean:message key="profil.create.title"/></html:link></li>
</ul>