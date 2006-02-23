<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<h2><bean:message key="form.mail"/></h2>
<ul>
	<logic:present role="mailingList.find">
		<li><html:link action="/mailingListVisu"><bean:message key="mailingList.list.title"/></html:link></li>
	</logic:present>
	<logic:present role="mailingType.find">
		<li><html:link action="/mailingTypeVisu"><bean:message key="mailType.list.title"/></html:link></li>
	</logic:present>
	<logic:present role="mailingType.create">
		<li><html:link action="/mailingTypeCreate?action=show"><bean:message key="mailType.create.title"/></html:link></li>
	</logic:present>
</ul>