<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<div id="bloc_menu1">
	<ul id="menu">
		<logic:present role="apprentice.retrieve,apprentice.find">
			<li><html:link action="/apprenticeSearch"><bean:message key="form.apprentice"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</logic:present>
		<logic:present role="firm.retrieve,firm.find">
			<li><html:link action="/companySearch"><bean:message key="form.company"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</logic:present>
		<logic:present role="teacherTutor.retrieve,teacherTutor.find">
			<li><html:link action="/teacherSearch?action=show"><bean:message key="form.teacher"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</logic:present>
		<logic:present role="candidate.retrieve,candidate.find">
			<li><html:link action="/candidateSearch?action=show"><bean:message key="form.recruitment"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</logic:present>
		<li><html:link action="/statisticsVisu"><bean:message key="form.statistics"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li><html:link action="/mailingListVisu"><bean:message key="form.mail"/></html:link></li>
	</ul>
 </div>