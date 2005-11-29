<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="form.mail"/></h2>
<ul>
	<li><html:link action="/mailingListVisu"><bean:message key="mailingList.list.title"/></html:link></li>
	<li><html:link action="/mailTypeVisu"><bean:message key="mailType.list.title"/></html:link></li>
	<li><html:link action="/mailTypeCreate"><bean:message key="mailType.create.title"/></html:link></li>
</ul>