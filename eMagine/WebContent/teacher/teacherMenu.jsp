<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<h2><bean:message key="form.teacher"/></h2>
<ul>
	<li><html:link action="/teacherSearch?action=show"><bean:message key="teacher.search.title"/></html:link></li>
	<li><html:link action="/teacherCreate?action=show"><bean:message key="teacher.create.title"/></html:link></li>
</ul>