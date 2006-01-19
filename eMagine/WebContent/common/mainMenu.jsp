<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<div id="bloc_menu1">
	<ul id="menu">
		<li><html:link action="/apprenticeSearch"><bean:message key="form.apprentice"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li><html:link action="/companySearch"><bean:message key="form.company"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li><html:link action="/teacherSearch?action=show"><bean:message key="form.teacher"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li><html:link action="/candidateSearch?action=show"><bean:message key="form.recruitment"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li><html:link action="/statisticsVisu"><bean:message key="form.statistics"/></html:link>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li><html:link action="/mailingListVisu"><bean:message key="form.mail"/></html:link></li>
	</ul>
 </div>