<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="form.recruitment"/></h2>
<ul>
	<li><html:link action="/candidateSearch"><bean:message key="candidate.search.title"/></html:link></li>
	<li><html:link action="/candidateCreate"><bean:message key="candidate.create.title"/></html:link></li>
	<li><html:link action="bringingTogether"><bean:message key="bringingTogether.title"/></html:link></li>
	<li><html:link action="/centerList"><bean:message key="center.list.title"/></html:link></li>
</ul>