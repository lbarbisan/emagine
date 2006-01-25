<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<h2><bean:message key="form.apprentice"/></h2>
<ul>
	<logic:present role="apprentice.find">
		<li><html:link action="/apprenticeSearch"><bean:message key="apprentice.search.title"/></html:link></li>
	</logic:present>
</ul>