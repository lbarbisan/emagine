<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<h2><bean:message key="form.recruitment"/></h2>
<ul>
	<logic:present role="candidate.find">
		<li><html:link action="/candidateSearch?action=show"><bean:message key="candidate.search.title"/></html:link></li>
	</logic:present>
	<logic:present role="candidate.create">
		<li><html:link action="/candidateCreate?action=show"><bean:message key="candidate.create.title"/></html:link></li>
	</logic:present>
	<logic:present role="firm.find,candidate.find">
		<li><html:link action="/bringingTogether?action=show"><bean:message key="bringingTogether.title"/></html:link></li>
	</logic:present>
	<logic:present role="formationCenter.find">
		<li><html:link action="/formationCenterList?action=list"><bean:message key="center.list.title"/></html:link></li>
	</logic:present>
</ul>