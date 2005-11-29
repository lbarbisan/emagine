<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="form.statistics"/></h2>
<ul>
	<li><html:link action="/statisticsVisu"><bean:message key="statistics.list.title"/></html:link></li>
	<li><html:link action="/statisticsCreate"><bean:message key="statistics.create.title"/></html:link></li>
</ul>