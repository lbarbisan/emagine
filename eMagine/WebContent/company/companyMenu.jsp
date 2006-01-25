<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<h2><bean:message key="form.company"/></h2>
<ul>
	<logic:present role="firm.find">
		<li><html:link action="/companySearch"><bean:message key="company.search.title"/></html:link></li>
	</logic:present>
	<logic:present role="firm.create">
		<li><html:link action="/companyCreate"><bean:message key="company.create.title"/></html:link></li>
	</logic:present>
</ul>