<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<h2><bean:message key="form.administration"/></h2>
<ul>
	<logic:present role="user.search">
		<li><html:link action="/userSearch?action=show"><bean:message key="user.search.title"/></html:link></li>
	</logic:present>
	<logic:present role="user.retrieve">
		<li><html:link action="/userCreate?action=show"><bean:message key="user.create.title"/></html:link></li>
	</logic:present>
	<logic:present role="profile.search">
		<li><html:link action="/profileList?action=list"><bean:message key="profil.list.title"/></html:link></li>
	</logic:present>
	<logic:present role="profile.create">
		<li><html:link action="/profileCreate?action=show"><bean:message key="profil.create.title"/></html:link></li>
	</logic:present>
</ul>