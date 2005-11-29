<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="form.company"/></h2>
<ul>
	<li><html:link action="/companySearch"><bean:message key="company.search.title"/></html:link></li>
	<li><html:link action="/companyCreate"><bean:message key="company.create.title"/></html:link></li>
</ul>